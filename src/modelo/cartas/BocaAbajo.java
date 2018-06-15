package modelo.cartas;

import modelo.excepciones.ExcepcionCartaBocaAbajo;
import modelo.general.Jugador;

public class BocaAbajo implements Posicion {
	
	@Override
	public void aplicarEfecto(Efecto efecto, Jugador atacante, Jugador oponente) throws ExcepcionCartaBocaAbajo {
		//No aplica efecto estando boca abajo
		throw new ExcepcionCartaBocaAbajo();
	}
}
