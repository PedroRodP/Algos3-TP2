package main.java.general;

import java.util.ArrayList;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionMazoVacio;

public class AlGoOh {
	
	private Turnador turnador;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private EstadoDeJuego estado;
	private Jugador jugadorActual;
	
	public AlGoOh() {
		
		estado = new EnProceso();
		
		jugadorA = new Jugador();
		jugadorB = new Jugador();
		
		asignarMazos();
		crearTurnador();
		establecerOponentes();
		
		
	}
	
	private void asignarMazos() {
		
		jugadorA.asignarMazo(new Mazo());
		jugadorB.asignarMazo(new Mazo());
		
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
		return jugadorActual;
	}
	
	public boolean estaEnProceso() {
		return estado.juegoEnProceso();
	}
	
	public void jugar() {
		//TODO tiene q estar en controlador
		/*while (estaEnProceso()) {  //Mientras el juego esta en proceso
			
			try {
				
			faseTomarCarta();
			fasePreparacion(); 
			faseAtaqueYTrampas(); //jugador puede morir
			faseMagicas(); //puede lanzar excepcion mazo vacio (Olla de la codicia)
			
			}catch (ExcepcionJuegoTerminado e) {
				estado = new Terminado();
			}
		}*/
	}
	
	public void faseTomarCarta(){
		jugadorActual.tomarCartaDelMazo();
		revisarEstadoDeJuego();
	}
	
	public void fasePreparacion() {
		
	}
	
	public void faseAtaqueYTrampas() {
		//jugadorActual.atacar(atacante, oponente);
		revisarEstadoDeJuego();
		
	}
	
	public void faseMagicas() {
		revisarEstadoDeJuego();
	}
	
	private void revisarEstadoDeJuego() { 
		Jugador oponente = jugadorActual.obtenerOponente();
		if (jugadorActual.seQuedoSinCartas() || jugadorActual.estaMuerto()) {
			this.finalizarConGanador(oponente);
			return;
		}
		if (jugadorActual.completoExodia() || oponente.estaMuerto()) {
			this.finalizarConGanador(jugadorActual);
			return;
		}
	}
	
	public void finalizarConGanador(Jugador ganador) {
		estado = new Terminado(ganador);
	}
	
	public Jugador ganador() throws ExcepcionJuegoNoTermino {
		return estado.devolverGanador(); 
	}
	
}
