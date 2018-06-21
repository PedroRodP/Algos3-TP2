package main.java.cartas;

public abstract class Carta {

	protected String nombre;
	protected Posicion posicion;

	public String nombre() {
		return nombre;
	}
	
	public void setBocaArriba() {
		this.posicion = new BocaArriba();
	}
	
	public void setBocaAbajo() {
		this.posicion = new BocaAbajo();
	}
	
	public boolean estaBocaArriba() {
		return posicion.estaBocaArriba();
	}
}
