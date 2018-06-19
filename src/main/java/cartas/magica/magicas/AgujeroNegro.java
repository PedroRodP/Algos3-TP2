package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.general.Jugador;

public class AgujeroNegro extends Magica {

	public AgujeroNegro() {
		nombre = "Agujero Negro";
	}

	public void aplicarEfectoA(Jugador jugador) {
		
		jugador.destruirTodosLosMonstruos();
		Jugador oponente = jugador.getOponente();
		oponente.destruirTodosLosMonstruos();
	}
}
