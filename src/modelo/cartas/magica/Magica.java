package modelo.cartas.magica;

import modelo.cartas.Carta;
import modelo.general.Jugador;
import modelo.tablero.Tablero;

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
