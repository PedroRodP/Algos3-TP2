package main.java.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

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
import main.java.excepciones.ExcepcionMonstruoYaAtaco;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionTurnoFinalizo;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class EstadoDeJuego extends Observable {
	
	private Fase fase;
	private Jugador jugador;
	private Turnador turnador;
	
	public EstadoDeJuego(Jugador jugadorA, Jugador jugadorB) {
		asignarTurnos(jugadorA, jugadorB);
		asignarEstadoDeJuego(jugadorA, jugadorB);
		siguienteTurno();
	}

	public String obtenerNombreDeFase(){
	    return fase.obtenerNombre();
    }
	
	private void asignarTurnos(Jugador jugadorA, Jugador jugadorB) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugadorA);
		jugadores.add(jugadorB);
		this.turnador = new Turnador(jugadores);
		setChanged();
		notifyObservers();
	}
	
	private void asignarEstadoDeJuego(Jugador jugadorA, Jugador jugadorB) {
		jugadorA.asignarEstadoDeJuego(this);
		jugadorB.asignarEstadoDeJuego(this);
		setChanged();
		notifyObservers();
	}
	
	private void inicializarTurno(Jugador jugador) {
		this.jugador = jugador;
		fase = new FasePreparacion();
		jugador.tomarCartaDelMazo();
	}
	
	public Jugador siguienteTurno() {
		Jugador jugador = turnador.siguienteTurno();
		inicializarTurno(jugador);
		setChanged();
		notifyObservers();
		return jugador;
	}
	
	public Jugador turnoActual() {
		return jugador;
	}
	
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		return fase.devolverGanador();
	}
	
	public void pasarASiguienteFase() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado {
		fase = fase.proxima();
		setChanged();
		notifyObservers();
	}
	
	public void terminarConGanador(Jugador jugador) {
		fase = new Terminado(jugador);
	}
	
	public void jugarCartaBocaAbajo(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		fase.jugarCartaBocaAbajo(carta, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void jugarCartaBocaArriba(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		fase.jugarCartaBocaArriba(carta, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		fase.jugarSacrificandoBocaAbajo(carta, sacrificados, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		fase.jugarSacrificandoBocaArriba(carta, sacrificados, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void voltearCarta(Carta carta) throws ExcepcionFaseIncorrecta {
		fase.voltearCarta(carta, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void aplicarMagica(Magica magica) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio, ExcepcionFaseIncorrecta {
		fase.aplicarMagica(magica, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void atacarCon(Monstruo atacante, Monstruo defensor) throws ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		fase.atacarCon(atacante, defensor, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void aplicarEfectoDeMonstruo(Monstruo monstruo, Monstruo elegido) throws ExcepcionFaseIncorrecta {
		fase.aplicarEfectoDeMonstruo(monstruo, elegido, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void colocarEnAtaque(Monstruo monstruo) throws ExcepcionFaseIncorrecta {
		fase.colocarEnAtaque(monstruo, jugador);
		setChanged();
		notifyObservers();
	}
	
	public void colocarEnDefensa(Monstruo monstruo) throws ExcepcionFaseIncorrecta {
		fase.colocarEnDefensa(monstruo, jugador);
		setChanged();
		notifyObservers();
	}
}
