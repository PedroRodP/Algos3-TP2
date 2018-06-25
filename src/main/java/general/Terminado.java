package main.java.general;

import main.java.excepciones.ExcepcionJuegoTerminado;

public class Terminado implements Fase {
	
	Jugador ganador;
	
	public Terminado(Jugador jugador) {
		ganador = jugador;
	}

	@Override
	public Jugador devolverGanador() {
		return ganador;
	}
	
	@Override
	public Fase proxima() {
		return this; //O lanzar ExcepcionJuegoTerminado
	}
	
	@Override
	public void ejecutar(Jugador jugador) throws ExcepcionJuegoTerminado {
		//Game over...
		throw new ExcepcionJuegoTerminado();
	}

}
