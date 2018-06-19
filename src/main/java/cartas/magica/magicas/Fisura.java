package main.java.cartas.magica.magicas;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class Fisura extends Magica {

	private Jugador oponente;

	public void afectaA(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public void aplicarEfecto() {
		LinkedList<Monstruo> monstruos = oponente.obtenerMonstruos();
		if (monstruos.isEmpty()) return;
		Monstruo monstruoConMenorAtaque = monstruos.getFirst();
		for (Monstruo m: monstruos) {
			if (m.obtenerAtaque() < monstruoConMenorAtaque.obtenerAtaque()) {
				monstruoConMenorAtaque = m;
			}
		}
		oponente.destruirMonstruo(monstruoConMenorAtaque);
	}
}
