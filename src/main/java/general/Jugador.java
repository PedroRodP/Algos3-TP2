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
	
	public Jugador getOponente() {
		return this.oponente;
	}
	
	public LinkedList<Monstruo> obtenerMonstruos() {
		return tablero.obtenerMonstruos();
	}
	
	public double vida() {
		return vida;
	}
	
	public void jugarCartaBocaAbajo(Carta carta){
		carta.colocarEn(tablero);
	}
	
	public void jugarCartaBocaArriba(Carta carta) {
		carta.colocarEn(tablero);
		this.voltear(carta);
	}
	
	public void voltear(Carta carta) {
		carta.aplicarEfectoA(this);
	}
	
	public void destruirMonstruo(Monstruo monstruo) {
		tablero.destruirCarta(monstruo);
	}
	
	public void destruirTodosLosMonstruos() {
		tablero.destruirTodosLosMonstruos();
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar {
		
		Batalla batalla = new Batalla(this, oponente);
		
		batalla.atacarCon(monstruoAtacante, monstruoRival);
	}
	
	public void infligirDanio(double danio) {
		this.vida -= Math.abs(danio);
	}

	public boolean cartaFueDestruida(Carta carta) {
		return tablero.cartaEstaEnCementerio(carta);
	}
	
}
