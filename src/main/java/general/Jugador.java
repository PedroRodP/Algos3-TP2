package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.Cementerio;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.*;

public class Jugador {

	private EstadoDeJuego estadoJuego;
	private int vida;
	private ZonaMonstruos zonaMonstruos;
	private ZonaMagicasYTrampas zonaMagicasYTrampas;
	private ZonaCampo zonaCampo;
	private Cementerio cementerio;
	private Jugador oponente;
	private Mano mano;
	private Mazo mazo;
	
	public Jugador() {
		this.vida = 8000;
		this.cementerio = new Cementerio();
		this.zonaMonstruos = new ZonaMonstruos(cementerio);
		this.zonaMagicasYTrampas = new ZonaMagicasYTrampas(cementerio);
		this.zonaCampo = new ZonaCampo(cementerio);
		this.mano = new Mano();
	}
	
	public void asignarEstadoDeJuego(EstadoDeJuego estado) {
		this.estadoJuego = estado;
	}
	
	public void establecerOponente(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public Jugador obtenerOponente() {
		return this.oponente;
	}
	
	public int obtenerPuntosDeVida() {
		return vida;
	}
	
	public void quitarVida(double danio) {
		vida -= (int) danio;
		if (vida <= 0) estadoJuego.terminarConGanador(oponente);
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<Monstruo> obtenerMonstruos() {
		return (LinkedList<Monstruo>) zonaMonstruos.obtenerMonstruos().clone();
	}
	
	public void jugarCartaBocaAbajo(Carta carta) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		mano.remover(carta);
		carta.setBocaAbajo();
		carta.agregarseEn(zonaMagicasYTrampas, zonaMonstruos, zonaCampo);
	}
	
	public void jugarCartaBocaArriba(Carta carta) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		mano.remover(carta);
		carta.setBocaArriba();
		carta.agregarseEn(zonaMagicasYTrampas, zonaMonstruos, zonaCampo);
	}
	
	public void jugarCartaBocaAbajoSacrificando(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		carta.agregarseEn(zonaMonstruos, sacrificados);
	}
	
	public void jugarCartaBocaArribaSacrificando(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		carta.setBocaArriba();
		carta.agregarseEn(zonaMonstruos, sacrificados);
	}

	public void aplicarMagica(Magica magica) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio {
		
		magica.aplicarEfecto(obtenerMonstruos(), oponente.obtenerMonstruos(), this);
	}
	
	public void voltearCarta(Carta carta) {
		carta.setBocaArriba();
	}

	
	public void ponerEnAtaque(Monstruo monstruo) {
		monstruo.colocarEnAtaque();
	}
	
	public void ponerEnDefensa(Monstruo monstruo) {
		monstruo.colocarEnDefensa();
	}
		
	public void tomarCartaDelMazo(){
		try {
			Carta carta = mazo.tomarCarta();
			this.mano.agregar(carta);
			if (completoExodia()) estadoJuego.terminarConGanador(this);
			
		} catch (ExcepcionMazoVacio e) {
			estadoJuego.terminarConGanador(oponente);
		}
	}
	
	public int cantidadDeCartasEnMano() {
		return mano.cantidadDeCartas();
	}
	
	public void asignarMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	public boolean completoExodia() {
		return mano.completoExodia();
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		activarEfectosDeCampo();
		oponente.activarEfectosDeCampo();
		
		Trampa trampa = this.oponente.obtenerPrimerCartaTrampa();
		trampa.aplicarA(monstruoAtacante, monstruoRival, this);
		
		desactivarEfectosDeCampo();
		oponente.desactivarEfectosDeCampo();
	}
	
	private void activarEfectosDeCampo() {
		
		Campo campo = zonaCampo.obtenerCampo();
		LinkedList<Monstruo> monstruosPropios = obtenerMonstruos();
		LinkedList<Monstruo> monstruosRivales = oponente.obtenerMonstruos();
		
		campo.activarEfecto(monstruosPropios, monstruosRivales);
	}
	
	private void desactivarEfectosDeCampo() {
		
		Campo campo = zonaCampo.obtenerCampo();
		LinkedList<Monstruo> monstruosPropios = obtenerMonstruos();
		LinkedList<Monstruo> monstruosRivales = oponente.obtenerMonstruos();
		
		campo.desactivarEfecto(monstruosPropios, monstruosRivales);
	}

	private Trampa obtenerPrimerCartaTrampa() {
		return zonaMagicasYTrampas.obtenerPrimeraCartaTrampa();
	}

	public void aplicarEfectoDeMonstruo(Monstruo monstruo, Monstruo elegido) {
		monstruo.aplicarEfecto(elegido);
	}
}
