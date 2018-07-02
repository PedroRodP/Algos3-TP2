package main.java.cartas.magica.magicas;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class Fisura extends Magica {

	public Fisura() {
		nombre = "Fisura";
	}

	public void aplicarA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales,
			Jugador jugador) {

		if (monstruosRivales.isEmpty()) return;
		
		Monstruo monstruoConMenorAtaque = monstruosRivales.getFirst();
		for (Monstruo m: monstruosRivales) {
			if (m.obtenerAtaque() < monstruoConMenorAtaque.obtenerAtaque()) {
				monstruoConMenorAtaque = m;
			}
		}
		monstruoConMenorAtaque.mandarAlCementerio();
	}
}
