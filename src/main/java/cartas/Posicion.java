package main.java.cartas;

import main.java.excepciones.ExcepcionCartaBocaAbajo;

public interface Posicion {

	public void aplicarEfecto(Efecto efecto) throws ExcepcionCartaBocaAbajo;
}
