package main.java.efectos;

import main.java.cartas.Efecto;
import main.java.general.Jugador;

public class EfectoAgujeroNegro implements Efecto {

	@Override
	public void aplicar(Jugador atacante, Jugador oponente) {
		
		atacante.destruirTodosTusMonstruos();
		oponente.destruirTodosTusMonstruos();
	}

}
