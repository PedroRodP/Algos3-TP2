package main.java.cartas;

import main.java.tablero.Tablero;

public abstract class Carta {

	protected String nombre;
	protected Posicion posicion;
	
	public abstract void colocarEn(Tablero tablero);

	public boolean tenesEsteNombre(String unNombreCarta){
		return this.nombre.equals(unNombreCarta);
	}

	public void setBocaArriba() {
		this.posicion = new BocaArriba();
	}
	
	public void setBocaAbajo() {
		this.posicion = new BocaAbajo();
	}
}
