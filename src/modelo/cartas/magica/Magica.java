package modelo.cartas.magica;

import modelo.cartas.Carta;
import modelo.cartas.Efecto;
import modelo.tablero.Tablero;

public class Magica extends Carta{



	public Magica(String unNombre) {
		super(unNombre);

	}

	public Magica(String unNombre, Efecto efecto) {
		super(unNombre,efecto);

	}
	
	public void colocarBocaAbajo(Tablero tablero) {
		tablero.agregarCarta(this);
	}
	
	public void colocarBocaArriba(Tablero tablero) {
		this.colocarBocaAbajo(tablero);
		this.voltear();

	}

}
