package main.java.cartas;

public class BocaAbajo implements Posicion {

	@Override
	public boolean estaBocaArriba() {
		return false;
	}
	
	@Override
	public boolean estaBocaAbajo() {
		return ! estaBocaArriba();
	}

}
