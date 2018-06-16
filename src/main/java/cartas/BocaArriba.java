package main.java.cartas;

import main.java.general.Jugador;

public class BocaArriba implements Posicion {

	public void aplicarEfecto(Efecto efecto) {
		efecto.aplicar();
	}
}
