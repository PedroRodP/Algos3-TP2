package main.java.cartas;

import main.java.excepciones.ExcepcionCartaBocaAbajo;

public class BocaAbajo implements Posicion {
	
	@Override
	public void aplicarEfecto(Efecto efecto) throws ExcepcionCartaBocaAbajo {
		//No aplica efecto estando boca abajo
		throw new ExcepcionCartaBocaAbajo();
	}
}
