package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Batalla;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;

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
	
	public void jugarCartaBocaAbajo(Carta carta){
		carta.colocarEnTablero(tablero);
		carta.setBocaAbajo();
	}
	
	public void jugarCartaBocaArriba(Carta carta) {
		carta.colocarEnTablero(tablero);
		carta.setBocaArriba();
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
