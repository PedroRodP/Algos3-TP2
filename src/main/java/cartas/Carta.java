package main.java.cartas;

import main.java.general.Tablero;

public abstract class Carta {

	protected String nombre;
	protected Posicion posicion;
	
	public abstract void colocarEnTablero(Tablero tablero);

	public void setBocaArriba() {
		this.posicion = new BocaArriba();
	}
	
	public void setBocaAbajo() {
		this.posicion = new BocaAbajo();
	}
}
