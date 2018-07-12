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

public class AlGoOh extends Observable {

	public EstadoDeJuego obtenerEstadoDelJuego() {
		return estado;
	}

	public ArrayList<Jugador> obtenerJugadores() {
		ArrayList<Jugador> list = new ArrayList<>();
		list.add(jugadorA);
		list.add(jugadorB);
		return list;
	}

	public static final String FASE_PREPARACION = "Fase de preparación";
	public static final String FASE_ATAQUE = "Fase ataque";
	public static final String FASE_MAGICA = "Fase mágica";

	private Jugador jugadorA;
	private Jugador jugadorB;
	private EstadoDeJuego estado;
	
	public AlGoOh() {
		jugadorA = new Jugador();
		jugadorB = new Jugador();
		
		asignarMazos();
		levantar5CartasDelMazo();
		establecerOponentes();
		
		estado = new EstadoDeJuego(jugadorA, jugadorB);
	}

	public String obtenerNombreDeFase(){
		return estado.obtenerNombreDeFase();
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

	
	private void establecerOponentes() {
		jugadorA.establecerOponente(jugadorB);
		jugadorB.establecerOponente(jugadorA);
	}

	public Jugador siguienteTurno() {
		Jugador actual = estado.siguienteTurno();
		setChanged();
		notifyObservers();
		return actual;
	}

	public void pasarASiguienteFase() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado {
		estado.pasarASiguienteFase();
		setChanged();
		notifyObservers();
	}
	
	public void jugarCartaBocaAbajo(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		estado.jugarCartaBocaAbajo(carta);
		setChanged();
		notifyObservers();
	}
	
	public void jugarCartaBocaArriba(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		estado.jugarCartaBocaArriba(carta);
		setChanged();
		notifyObservers();
	}
	
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		estado.jugarSacrificandoBocaAbajo(carta, sacrificados);
		setChanged();
		notifyObservers();
	}
	
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		estado.jugarSacrificandoBocaArriba(carta, sacrificados);
		setChanged();
		notifyObservers();
	}
	
	public void voltearCarta(Carta carta) throws ExcepcionFaseIncorrecta {
		estado.voltearCarta(carta); //TODO si la carta ya esta boca arriba (ver ese caso)
		setChanged();
		notifyObservers();
	}
	
	public void aplicarMagica(Magica magica) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio, ExcepcionFaseIncorrecta {
		estado.aplicarMagica(magica);
		setChanged();
		notifyObservers();
	}
	
	public void aplicarEfectoDeMonstruo(Monstruo monstruo, Monstruo elegido) throws ExcepcionFaseIncorrecta {
		estado.aplicarEfectoDeMonstruo(monstruo, elegido);
		setChanged();
		notifyObservers();
	}
	
	public void atacarCon(Monstruo atacante, Monstruo defensor) throws ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		estado.atacarCon(atacante, defensor);
		setChanged();
		notifyObservers();
	}
	
	public void colocarEnAtaque(Monstruo monstruo) throws ExcepcionFaseIncorrecta {
		estado.colocarEnAtaque(monstruo);
		setChanged();
		notifyObservers();
	}
	
	public void colocarEnDefensa(Monstruo monstruo) throws ExcepcionFaseIncorrecta {
		estado.colocarEnDefensa(monstruo);
		setChanged();
		notifyObservers();
	}

	public Jugador ganador() throws ExcepcionJuegoNoTermino {
		return estado.devolverGanador(); 
	}

	public Jugador turnoActual() {
		return estado.turnoActual();
	}
	
}
