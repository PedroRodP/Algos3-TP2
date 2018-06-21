package main.java.cartas;

public class BocaArriba implements Posicion {

	@Override
	public boolean estaBocaArriba() {
		return true;
	}
	
	@Override
	public boolean estaBocaAbajo() {
		return false;
	}
	
}
