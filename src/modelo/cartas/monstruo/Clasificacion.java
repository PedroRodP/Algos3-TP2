package modelo.cartas.monstruo;

public class Clasificacion {
	
	private double cantidadDeEstrellas;
	
	public Clasificacion(int estrellas) {
		cantidadDeEstrellas = estrellas;
	}
	
	public int cantidadDeSacrificiosPorInvocacion() {
		if (cantidadDeEstrellas < 4) {
			return 0;
		}
		else if (cantidadDeEstrellas >= 4 && cantidadDeEstrellas < 6) {
			return 1;
		}
		else {
			return 2;
		}
	}

}
