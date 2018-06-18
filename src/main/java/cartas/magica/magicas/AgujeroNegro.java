package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.efectos.EfectoAgujeroNegro;
import main.java.general.Jugador;

public class AgujeroNegro extends Magica {

	public AgujeroNegro(Jugador poseedor, Jugador oponente) {
		NOMBRE = "Agujero Negro";
		this.efecto = new EfectoAgujeroNegro(poseedor, oponente);
	}

}
