package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class EstadoDeJuego {
	
	private Fase fase;
	
	public EstadoDeJuego() {
		nuevoTurno();
	}
	
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		return fase.devolverGanador();
	}
	
	public void nuevoTurno() {
		this.fase = new FaseTomarCarta();
	}
	
	public void ejecutarFase(Jugador jugador) throws ExcepcionJuegoTerminado, ExcepcionTurnoFinalizo {
		fase.ejecutar(jugador);
		pasarASiguienteFase();
	}
	
	private void pasarASiguienteFase() throws ExcepcionTurnoFinalizo {
		fase = fase.proxima();
	}
	
	public void terminarConGanador(Jugador jugador) {
		fase = new Terminado(jugador);
	}
}
