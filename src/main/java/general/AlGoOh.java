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
	}
	
	public void tomarCarta() throws ExcepcionFaseIncorrecta {
		estado.tomarCarta();
	}
	
	public void jugarCartaBocaAbajo(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		estado.jugarCartaBocaAbajo(carta);
	}
	
	public void jugarCartaBocaArriba(Carta carta) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		estado.jugarCartaBocaArriba(carta);
	}
	
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		estado.jugarSacrificandoBocaAbajo(carta, sacrificados);
	}
	
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		estado.jugarSacrificandoBocaArriba(carta, sacrificados);
	}
	
	public void voltearCarta(Carta carta) throws ExcepcionFaseIncorrecta {
		estado.voltearCarta(carta); //TODO si la carta ya esta boca arriba (ver ese caso)
	}
	
	public void aplicarMagica(Magica magica) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio, ExcepcionFaseIncorrecta {
		estado.aplicarMagica(magica);
	}
	
	public void aplicarEfectoDeMonstruo(Monstruo monstruo, Monstruo elegido) throws ExcepcionFaseIncorrecta {
		estado.aplicarEfectoDeMonstruo(monstruo, elegido);
	}
	
	public void atacarCon(Monstruo atacante, Monstruo defensor) throws ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		estado.atacarCon(atacante, defensor);
	}
	
	public void colocarEnAtaque(Monstruo monstruo) throws ExcepcionFaseIncorrecta {
		estado.colocarEnAtaque(monstruo);
	}
	
	public void colocarEnDefensa(Monstruo monstruo) throws ExcepcionFaseIncorrecta {
		estado.colocarEnDefensa(monstruo);
	}

	public Jugador ganador() throws ExcepcionJuegoNoTermino {
		return estado.devolverGanador(); 
	}

	public Jugador turnoActual() {
		return estado.turnoActual();
	}
	
}
