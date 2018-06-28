package main.java.cartas.trampa;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class NoTrampa extends Trampa {

	@Override
	public void aplicarA(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor) {}

	@Override
	public void desactivarEfecto(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor) {}

}
