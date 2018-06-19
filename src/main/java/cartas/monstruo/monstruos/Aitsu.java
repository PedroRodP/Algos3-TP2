package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class Aitsu extends Monstruo {

	public Aitsu() {
		super(100, 100, 5);
		nombre = "Aitsu";
	}
	
	public void aplicarEfectoA(Jugador jugador) {
		//Aitsu no tiene efecto
	}
}
