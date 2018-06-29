package main.java.general;

import java.util.ArrayList;

import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class AlGoOh {
	
	private Turnador turnador;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private EstadoDeJuego estado;
	private Jugador jugadorActual;
	
	public AlGoOh() {
		
		jugadorA = new Jugador();
		jugadorB = new Jugador();
		estado = new EstadoDeJuego();
		
		asignarEstadoDeJuego();
		asignarMazos();
		levantar5CartasDelMazo();
		crearTurnador();
		establecerOponentes();
		
	}
	
	private void asignarEstadoDeJuego() {
		jugadorA.asignarEstadoDeJuego(estado);
		jugadorB.asignarEstadoDeJuego(estado);;
	}
	
	private void asignarMazos() {
		
		jugadorA.asignarMazo(new Mazo());
		jugadorB.asignarMazo(new Mazo());
		
	}
	
	private void levantar5CartasDelMazo() {
		
		for (int i = 0; i < 5; i++) {
			jugadorA.tomarCartaDelMazo();
			jugadorB.tomarCartaDelMazo();
		}
	}
	
	private void crearTurnador() {

		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugadorA);
		jugadores.add(jugadorB);
		
		this.turnador = new Turnador(jugadores);
	}
	
	private void establecerOponentes() {
		
		jugadorA.establecerOponente(jugadorB);
		jugadorB.establecerOponente(jugadorA);
	}
	
	public Jugador siguienteTurno() {
		jugadorActual = turnador.siguienteTurno();
		estado.nuevoTurno();
		return jugadorActual;
	}
	
	//Se llama al metodo jugar() 4 veces (FaseTomarCarta, FasePreparacion, FaseAtaque, FaseMagicas)
	
	/*	La ultima lanzara ExcepcionTurnoFinalizo cuando se acaban las fases 
	 *	para dar aviso de llamar al metodo siguienteTurno() */
	
	public void jugar() throws ExcepcionJuegoTerminado, ExcepcionTurnoFinalizo {
		estado.ejecutarFase(jugadorActual);
	}
	
	public void pasarASiguienteFase() throws ExcepcionTurnoFinalizo {
		estado.pasarASiguienteFase();
	}
	
	public Jugador ganador() throws ExcepcionJuegoNoTermino {
		return estado.devolverGanador(); 
	}
	
}
