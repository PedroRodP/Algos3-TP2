package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Jugador;

public class OllaDeLaCodicia extends Magica {

	private Jugador afectado;
	
	public void afectaA(Jugador jugador) {
		this.afectado = jugador;
	}
	
	public void aplicarEfecto() throws ExcepcionMazoVacio {
		
		afectado.tomarCartaDelMazo();
		afectado.tomarCartaDelMazo();
	}

}
