package main.java.cartas.magica.magicas;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Jugador;

public class OllaDeLaCodicia extends Magica {
	
	public OllaDeLaCodicia() {
		super();
		nombre = "Olla de la codicia";
	}
	
	@Override
	protected void aplicarA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales,
			Jugador jugador) throws ExcepcionMazoVacio {
		
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
	}

}
