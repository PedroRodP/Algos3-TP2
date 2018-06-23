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
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public class Jugador {

	private Vida vida;
	private ZonaMonstruos zonaMonstruos;
	private ZonaMagicasYTrampas zonaMagicasYTrampas;
	private ZonaCampo zonaCampo;
	private Cementerio cementerio;
	private Jugador oponente;
	private Mano mano;
	private Mazo mazo;
	private boolean mazoVacio;
	
	public Jugador() {
		this.vida = new Vida(8000);
		this.cementerio = new Cementerio();
		this.zonaMonstruos = new ZonaMonstruos(cementerio);
		this.zonaMagicasYTrampas = new ZonaMagicasYTrampas(cementerio);
		this.zonaCampo = new ZonaCampo(cementerio);
		this.mano = new Mano();
	}

	public double obtenerPuntosDeVida(){
		return vida.getVida();
	}
	
	public void establecerOponente(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public Jugador obtenerOponente() {
		return this.oponente;
	}
	
	public LinkedList<Monstruo> obtenerMonstruos() {
		return (LinkedList<Monstruo>) zonaMonstruos.obtenerMonstruos().clone();
	}
	
	public Vida getVida() {
		return vida;
	}
	
	public void jugarMonstruoBocaAbajo(Monstruo monstruo) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		
		if (monstruo.sacrificiosNecesariosPorInvocacion() != 0) {
			throw new ExcepcionSacrificiosInsuficientes();
		}
		
		monstruo.setBocaAbajo();
		monstruo.agregarseEn(zonaMonstruos);
	}
	
	public void jugarMonstruoBocaArriba(Monstruo monstruo) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		
		if (monstruo.sacrificiosNecesariosPorInvocacion() != 0) {
			throw new ExcepcionSacrificiosInsuficientes();
		}
		
		monstruo.setBocaArriba();
		monstruo.agregarseEn(zonaMonstruos);
	}
	
	public void jugarMonstruoBocaAbajoSacrificando(Monstruo monstruo, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		monstruo.setBocaAbajo();
		monstruo.agregarseSacrificando(zonaMonstruos, sacrificados);
	}
	
	public void jugarMonstruoBocaArribaSacrificando(Monstruo monstruo, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		monstruo.setBocaArriba();
		monstruo.agregarseSacrificando(zonaMonstruos, sacrificados);
	}
	
	public void jugarMagicaBocaAbajo(Magica magica) throws ExcepcionZonaCompleta {
		magica.setBocaAbajo();
		magica.agregarseEn(zonaMagicasYTrampas);
	}
	
	public void jugarMagicaBocaArriba(Magica magica) throws ExcepcionZonaCompleta {
		magica.setBocaArriba();
		magica.agregarseEn(zonaMagicasYTrampas);
	}
	
	public void jugarTrampaBocaAbajo(Trampa trampa) throws ExcepcionZonaCompleta {
		trampa.setBocaAbajo();
		trampa.agregarseEn(zonaMagicasYTrampas);
	}
	
	public void jugarTrampaBocaArriba(Trampa trampa) throws ExcepcionZonaCompleta {
		trampa.setBocaArriba();
		trampa.agregarseEn(zonaMagicasYTrampas);
	}
	
	public void jugarCampo(Campo campo) { //Los campos se activan directamente
		campo.setBocaArriba();
		campo.agregarseEn(zonaCampo);
	}
	
	public void voltearCarta(Carta carta) {
		carta.setBocaArriba();
	}

	public void atacar(Monstruo atacante, Monstruo rival) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		atacante.atacar(rival,vida,oponente.getVida());
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
			
		}catch (ExcepcionMazoVacio e){
			
			mazoVacio = true;
			
		}
	}
	
	public int cantidadDeCartasEnMano() {
		return mano.cantidadDeCartas();
	}
	
	public boolean seQuedoSinCartas() {
		return mazoVacio;
	}
	
	public void asignarMazo(Mazo mazo) {
		this.mazo = mazo;
		this.mazoVacio = false;
	}
	
	public boolean completoExodia() {
		return mano.completoExodia();
	}
	
	public boolean estaMuerto() {
		return vida.estaMuerto();
	}
}
