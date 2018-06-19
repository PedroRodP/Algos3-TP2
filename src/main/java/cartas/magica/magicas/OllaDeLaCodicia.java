package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Jugador;

public class OllaDeLaCodicia extends Magica {

	public void aplicarEfectoA(Jugador jugador) throws ExcepcionMazoVacio {
		
		jugador.tomarCartaDelMazo();
		jugador.tomarCartaDelMazo();
	}

}
