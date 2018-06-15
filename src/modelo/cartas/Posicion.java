package modelo.cartas;

import modelo.excepciones.ExcepcionCartaBocaAbajo;
import modelo.general.Jugador;

public interface Posicion {

	public void aplicarEfecto(Efecto efecto, Jugador atacante, Jugador oponente) throws ExcepcionCartaBocaAbajo;
}
