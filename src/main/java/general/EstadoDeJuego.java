package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;

public interface EstadoDeJuego {
	
	public boolean juegoEnProceso();
	
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino;
}
