package main.java.cartas.magica.magicas;

import main.java.cartas.magica.Magica;
import main.java.general.Jugador;

public class AgujeroNegro extends Magica {

	private Jugador afectado;
	
	public void afectaA(Jugador jugador) {
		this.afectado = jugador;
	}

	public void aplicarEfecto() {
		
		afectado.destruirTodosLosMonstruos();
		Jugador oponente = afectado.getOponente();
		oponente.destruirTodosLosMonstruos();
	}
}
