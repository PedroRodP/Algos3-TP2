package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.general.Jugador;

import java.util.LinkedList;

public class AgujeroNegro extends Magica {
	
	public AgujeroNegro() {
		nombre = "Agujero negro";
	}

	public void aplicarEfecto(LinkedList<Monstruo> monstruosPropios,LinkedList<Monstruo> monstruosOponentes) throws ExcepcionCartaBocaAbajo {
		
		if (posicion.estaBocaAbajo()) { throw new ExcepcionCartaBocaAbajo(); }

		for (Monstruo m : monstruosPropios) m.mandarAlCementerio();
		for (Monstruo m : monstruosOponentes) m.mandarAlCementerio();
		this.mandarAlCementerio();
	}
}
