package main.java.cartas;

import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.general.Jugador;

public interface Posicion {

	public void aplicarEfecto(Efecto efecto, Jugador atacante, Jugador oponente) throws ExcepcionCartaBocaAbajo;
}
