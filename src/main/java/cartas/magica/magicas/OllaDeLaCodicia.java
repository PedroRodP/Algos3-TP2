package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Jugador;

public class OllaDeLaCodicia extends Magica {
	
	public OllaDeLaCodicia() {
		nombre = "Olla de la codicia";
	}
	
	public void aplicarEfecto(Jugador afectado) throws ExcepcionMazoVacio, ExcepcionCartaBocaAbajo {
		
		if (posicion.estaBocaAbajo()) { throw new ExcepcionCartaBocaAbajo(); }
		
		afectado.tomarCartaDelMazo();
		afectado.tomarCartaDelMazo();
	}

}
