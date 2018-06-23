package main.java.cartas.magica.magicas;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.general.Jugador;

public class Fisura extends Magica {

	public Fisura() {
		nombre = "Fisura";
	}

	public void aplicarEfecto(LinkedList<Monstruo> monstruos) throws ExcepcionCartaBocaAbajo {
		
		if (posicion.estaBocaAbajo()) { throw new ExcepcionCartaBocaAbajo(); }
		if (monstruos.isEmpty()) return;
		
		Monstruo monstruoConMenorAtaque = monstruos.getFirst();
		for (Monstruo m: monstruos) {
			if (m.obtenerAtaque() < monstruoConMenorAtaque.obtenerAtaque()) {
				monstruoConMenorAtaque = m;
			}
		}
		monstruoConMenorAtaque.mandarAlCementerio();
	}
}
