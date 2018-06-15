package main.java.magica;

import main.java.cartas.Carta;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public abstract class Magica extends Carta{

	public Magica(String unNombre) {
		super(unNombre);
	}
	
	public void colocarBocaArriba(Tablero tablero, Jugador atacante, Jugador oponente) {
		this.colocarBocaAbajo(tablero);
		this.activarEfecto(atacante, oponente);
	}
	
	public void colocarBocaAbajo(Tablero tablero) {
		tablero.agregarCarta(this);
	}
}
