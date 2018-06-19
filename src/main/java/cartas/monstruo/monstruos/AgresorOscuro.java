package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class AgresorOscuro extends Monstruo {

	public AgresorOscuro() {
		super(1200, 1200, 4);
		nombre = "Agresor oscuro";
	}
	
	public void aplicarEfectoA(Jugador jugador) {
		//AgresorOscuro no tiene efecto
	}
	
}
