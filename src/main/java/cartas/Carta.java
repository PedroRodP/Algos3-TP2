package main.java.cartas;

public abstract class Carta {

	protected String nombre;
	protected Posicion posicion;
	protected Lugar lugar;

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

    public abstract void mandarAlCementerio();

	public boolean estaEnElCementerio(){
	    return lugar.esUnCementerio();
    }
}
