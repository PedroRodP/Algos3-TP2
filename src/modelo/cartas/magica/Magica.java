package modelo.cartas.magica;

import modelo.cartas.Carta;
import modelo.tablero.Tablero;

public class Magica extends Carta{

	public Magica(String unNombre) {
		super(unNombre);
	}
	
	public void colocarBocaAbajo(Tablero tablero) {
		tablero.agregarCarta(this);
	}
	
	public void colocarBocaArriba(Tablero tablero) {
		tablero.agregarCarta(this);
	}
}
