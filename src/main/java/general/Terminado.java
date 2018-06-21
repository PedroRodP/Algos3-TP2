package main.java.general;

public class Terminado implements EstadoDeJuego {
	
	Jugador ganador;
	
	public Terminado(Jugador jugador) {
		ganador = jugador;
	}
	
	public boolean juegoEnProceso() {
		return false;
	}
	
	public Jugador devolverGanador() {
		return ganador;
	}

}
