package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Tablero;

public abstract class Magica extends Carta{

	public void colocarEnTablero(Tablero tablero) throws ExcepcionZonaCompleta {
		tablero.agregarCarta(this);
	}
	
}
