package main.java.general;

import main.java.excepciones.ExcepcionJuegoTerminado;

public class Terminado extends Fase {

	@Override
	public String obtenerNombre() {
		return "Juego terminado";
	}
	
	private Jugador ganador;
	
	public Terminado(Jugador jugador) {
		ganador = jugador;
	}

	@Override
	public Jugador devolverGanador() {
		return ganador;
	}
	
	@Override
	public Fase proxima() throws ExcepcionJuegoTerminado {
		throw new ExcepcionJuegoTerminado();
	}

}
