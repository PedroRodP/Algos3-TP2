package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.efectos.EfectoAgujeroNegro;

public class AgujeroNegro extends Magica {

	public AgujeroNegro() {
		NOMBRE = "Agujero negro";
		this.efecto = new EfectoAgujeroNegro();
	}

}
