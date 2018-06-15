package modelo.cartas.efectos;

import modelo.cartas.Efecto;
import modelo.general.Jugador;

public class EfectoAgujeroNegro implements Efecto {

	@Override
	public void aplicar(Jugador atacante, Jugador oponente) {
		
		atacante.destruirTodosTusMonstruos();
		oponente.destruirTodosTusMonstruos();
	}

}
