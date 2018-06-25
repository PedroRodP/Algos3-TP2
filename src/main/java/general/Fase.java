package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public interface Fase {

	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino;
	
	public Fase proxima() throws ExcepcionTurnoFinalizo;
	
	public void ejecutar(Jugador jugador) throws ExcepcionJuegoTerminado;
}
