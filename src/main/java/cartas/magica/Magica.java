package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.general.Tablero;

public abstract class Magica extends Carta{

	public void colocarEnTablero(Tablero tablero) {
		tablero.agregarCarta(this);;
	}
	
}
