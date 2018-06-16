package main.java.cartas.magica.magicas;

import main.java.efectos.EfectoAgujeroNegro;
import main.java.magica.Magica;

public class AgujeroNegro extends Magica {

	public AgujeroNegro() {
		NOMBRE = "Agujero Negro";
		this.efecto = new EfectoAgujeroNegro();
	}

}
