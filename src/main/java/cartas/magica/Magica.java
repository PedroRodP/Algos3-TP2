package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public abstract class Magica extends Carta{

	public void colocarBocaArriba(Tablero tablero) {
		this.colocarBocaAbajo(tablero);
	}
	
	public void colocarBocaAbajo(Tablero tablero) {
		tablero.agregarCarta(this);
	}
}
