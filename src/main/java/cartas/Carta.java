package main.java.cartas;

import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.general.Tablero;

public abstract class Carta {

	protected String nombre;
	protected Posicion posicion;

	public String nombre() {
		return nombre;
	}
	
	public abstract void colocarEnTablero(Tablero tablero) throws ExcepcionSacrificiosInsuficientes;
	
	public void setBocaArriba() {
		this.posicion = new BocaArriba();
	}
	
	public void setBocaAbajo() {
		this.posicion = new BocaAbajo();
	}
}
