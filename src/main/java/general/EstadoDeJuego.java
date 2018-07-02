package main.java.general;

import java.util.ArrayList;
import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionCartaNoNecesitaSacrificios;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionTurnoFinalizo;
import main.java.excepciones.ExcepcionZonaCompleta;

public class EstadoDeJuego {
	
	private Fase fase;
	private Jugador jugador;
	private Turnador turnador;
	
	public EstadoDeJuego(Jugador jugadorA, Jugador jugadorB) {
		
		asignarTurnos(jugadorA, jugadorB);
		asignarEstadoDeJuego(jugadorA, jugadorB);
		
	}
	
	private void asignarTurnos(Jugador jugadorA, Jugador jugadorB) {
		
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugadorA);
		jugadores.add(jugadorB);
		
		this.turnador = new Turnador(jugadores);
	}
	
	private void asignarEstadoDeJuego(Jugador jugadorA, Jugador jugadorB) {
		jugadorA.asignarEstadoDeJuego(this);
		jugadorB.asignarEstadoDeJuego(this);;
	}
	
	public Jugador siguienteTurno() {
		jugador = turnador.siguienteTurno();
		return jugador;
	}
	
	public Jugador turnoActual() {
		return jugador;
	}
	
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		return fase.devolverGanador();
	}
	
	public void nuevoTurnoDe(Jugador jugador) {
		this.jugador = jugador;
		this.fase = new FaseTomarCarta();
	}
	
	public void pasarASiguienteFase() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado {
		fase = fase.proxima();
	}
	
	public void terminarConGanador(Jugador jugador) {
		fase = new Terminado(jugador);
	}
	
	public void tomarCarta() throws ExcepcionFaseIncorrecta {
		fase.tomarCarta(jugador);
	}
	
	public void jugarCartaBocaAbajo(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		fase.jugarCartaBocaAbajo(carta, jugador);
	}
	
	public void jugarCartaBocaArriba(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		fase.jugarCartaBocaArriba(carta, jugador);
	}
	
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios {
		fase.jugarSacrificandoBocaAbajo(carta, sacrificados, jugador);
	}
	
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios {
		fase.jugarSacrificandoBocaArriba(carta, sacrificados, jugador);
	}
	
	public void voltearCarta(Carta carta) throws ExcepcionFaseIncorrecta {
		fase.voltearCarta(carta, jugador);
	}
	
	public void aplicarMagica(Magica magica) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio, ExcepcionFaseIncorrecta {
		fase.aplicarMagica(magica, jugador);
	}
	
	public void atacarCon(Monstruo atacante, Monstruo defensor) throws ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		fase.atacarCon(atacante, defensor, jugador);
	}
}
