package modelo.cartas.monstruo;

public class Clasificacion {
	
	private double cantidadDeEstrellas;
	
	public Clasificacion(int estrellas) {
		cantidadDeEstrellas = estrellas;
	}
	
	public int cantidadDeSacrificiosPorInvocacion() {
		if (cantidadDeEstrellas < 5) {
			return 0;
		}
		else if (cantidadDeEstrellas == 5) {
			return 1;
		}
		else {
			return 2;
		}
	}

}
