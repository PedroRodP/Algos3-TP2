package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;

public class EnProceso implements EstadoDeJuego {
	
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		throw new ExcepcionJuegoNoTermino();
	}
	
	public boolean juegoEnProceso() {
		return true;
	}
	
}
