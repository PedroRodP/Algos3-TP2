package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.tablero.Tablero;

public class Jugador {

	private double vida;
	private Tablero tablero;
	private Jugador oponente;
	
	public Jugador() {
		
		this.vida = 8000;
		this.tablero = new Tablero();
	}
	
	public void establecerOponente(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public LinkedList<Monstruo> obtenerMonstruos() {
		return tablero.obtenerMonstruos();
	}
	
	public double vida() {
		return vida;
	}
	
	public void jugarCartaBocaAbajo(Carta carta){
		carta.colocarBocaAbajo(tablero);
	}
	
	public void jugarCartaBocaArriba(Carta carta) {
		carta.colocarBocaArriba(tablero);
	}
	
	public void destruirMonstruo(Monstruo monstruo) {
		tablero.destruirCarta(monstruo);
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar {
		
		Batalla batalla = new Batalla(this, oponente);
		
		batalla.atacarCon(monstruoAtacante, monstruoRival);
	}
	
	public void infligirDanio(double danio) {
		this.vida -= Math.abs(danio);
	}
	
}
