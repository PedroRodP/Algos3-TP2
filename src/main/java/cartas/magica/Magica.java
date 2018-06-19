package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.tablero.Tablero;

public abstract class Magica extends Carta{

	public void colocarEn(Tablero tablero) {
		tablero.agregarCarta(this);;
	}
}
