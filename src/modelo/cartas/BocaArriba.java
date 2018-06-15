package modelo.cartas;

import modelo.general.Jugador;

public class BocaArriba implements Posicion {

	public void aplicarEfecto(Efecto efecto, Jugador atacante, Jugador oponente) {
		efecto.aplicar(atacante, oponente);
	}
}
