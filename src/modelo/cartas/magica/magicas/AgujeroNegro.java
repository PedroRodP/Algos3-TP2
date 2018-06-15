package modelo.cartas.magica.magicas;

import modelo.cartas.efectos.EfectoAgujeroNegro;
import modelo.cartas.magica.Magica;

public class AgujeroNegro extends Magica {
	
	public AgujeroNegro() {
		
		super("Agujero negro");
		this.efecto = new EfectoAgujeroNegro();
	}

}
