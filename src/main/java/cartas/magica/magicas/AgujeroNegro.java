package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

import java.util.LinkedList;

public class AgujeroNegro extends Magica {
	
	public AgujeroNegro() {
		super();
		nombre = "Agujero negro";
	}

	@Override
	protected void aplicarA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosOponentes, Jugador jugador) {

		for (Monstruo m : monstruosPropios) m.mandarAlCementerio();
		for (Monstruo m : monstruosOponentes) m.mandarAlCementerio();
	}
}
