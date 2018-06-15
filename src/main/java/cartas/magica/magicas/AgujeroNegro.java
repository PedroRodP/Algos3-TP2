package main.java.cartas.magica.magicas;

import main.java.efectos.EfectoAgujeroNegro;
import main.java.magica.Magica;

public class AgujeroNegro extends Magica {
	
	public AgujeroNegro() {
		
		super("Agujero negro");
		this.efecto = new EfectoAgujeroNegro();
	}

}
