package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Batalla;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public class Jugador {

	private double vida;
	private Tablero tablero;
	private Jugador oponente;
	private Mano mano;
	private Mazo mazo;
	private boolean mazoVacio;
	
	public Jugador() {
		
		this.vida = 8000;
		this.tablero = new Tablero();
		this.mano = new Mano();
	}
	
	public void establecerOponente(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public Jugador obtenerOponente() {
		return this.oponente;
	}
	
	public LinkedList<Monstruo> obtenerMonstruos() {
		return tablero.obtenerMonstruos();
	}
	
	public double vida() {
		return vida;
	}
	
	public void jugarMonstruoBocaAbajo(Monstruo monstruo) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		
		if (monstruo.sacrificiosNecesariosPorInvocacion() != 0) {
			throw new ExcepcionSacrificiosInsuficientes();
		}
		
		monstruo.setBocaAbajo();
		tablero.agregarCarta(monstruo);
	}
	
	public void jugarMonstruoBocaArriba(Monstruo monstruo) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		
		if (monstruo.sacrificiosNecesariosPorInvocacion() != 0) {
			throw new ExcepcionSacrificiosInsuficientes();
		}
		
		monstruo.setBocaArriba();
		tablero.agregarCarta(monstruo);
	}
	
	public void jugarMonstruoBocaAbajoSacrificando(Monstruo monstruo, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		monstruo.setBocaAbajo();
		monstruo.colocarEnTablero(tablero, sacrificados);
	}
	
	public void jugarMonstruoBocaArribaSacrificando(Monstruo monstruo, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		monstruo.setBocaArriba();
		monstruo.colocarEnTablero(tablero, sacrificados);
	}
	
	public void jugarMagicaBocaAbajo(Magica magica) throws ExcepcionZonaCompleta {
		magica.setBocaAbajo();
		tablero.agregarCarta(magica);
	}
	
	public void jugarMagicaBocaArriba(Magica magica) throws ExcepcionZonaCompleta {
		magica.setBocaArriba();
		tablero.agregarCarta(magica);
	}
	
	public void jugarTrampaBocaAbajo(Trampa trampa) throws ExcepcionZonaCompleta {
		trampa.setBocaAbajo();
		tablero.agregarCarta(trampa);
	}
	
	public void jugarTrampaBocaArriba(Trampa trampa) throws ExcepcionZonaCompleta {
		trampa.setBocaArriba();
		tablero.agregarCarta(trampa);
	}
	
	public void jugarCampo(Campo campo) { //Los campos se activan directamente
		campo.setBocaArriba();
		tablero.agregarCarta(campo);
	}
	
	public void voltearCarta(Carta carta) {
		carta.setBocaArriba();
	}
	
	public void destruirMonstruo(Monstruo monstruo) {
		tablero.destruirCarta(monstruo);
	}
	
	public void destruirTodosLosMonstruos() {
		tablero.destruirCartas(tablero.obtenerMonstruos());
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Batalla batalla = new Batalla(this, oponente);
		
		batalla.atacarCon(monstruoAtacante, monstruoRival);
	}
	
	public void infligirDanio(double danio){
		this.vida -= Math.abs(danio);
	}

	public boolean cartaFueDestruida(Carta carta) {
		return tablero.cartaEstaEnCementerio(carta);
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
		return vida <= 0;
	}
}
