package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class DragonBlancoDeOjosAzules extends Monstruo {

	public DragonBlancoDeOjosAzules() {
		super(3000, 2500, 8);
		nombre = "Dragon blanco de ojos azules";
	}
	
	public void aplicarEfectoA(Jugador jugador) {
		//DragonBlancoDeOjosAzules no tiene efecto
	}
}
