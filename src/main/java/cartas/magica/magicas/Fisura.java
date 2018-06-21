package main.java.cartas.magica.magicas;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.general.Jugador;

public class Fisura extends Magica {

	private Jugador afectado;

	public Fisura() {
		nombre = "Fisura";
	}
	
	public void afectaA(Jugador jugador) {
		this.afectado = jugador;
	}
	
	public void aplicarEfecto() throws ExcepcionCartaBocaAbajo {
		
		if (posicion.estaBocaAbajo()) { throw new ExcepcionCartaBocaAbajo(); }
		
		LinkedList<Monstruo> monstruos = afectado.obtenerMonstruos();
		if (monstruos.isEmpty()) return;
		
		Monstruo monstruoConMenorAtaque = monstruos.getFirst();
		for (Monstruo m: monstruos) {
			if (m.obtenerAtaque() < monstruoConMenorAtaque.obtenerAtaque()) {
				monstruoConMenorAtaque = m;
			}
		}
		
		afectado.destruirMonstruo(monstruoConMenorAtaque);
	}
}
