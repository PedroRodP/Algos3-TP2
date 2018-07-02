package main.java.general;

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
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class AlGoOh {
	
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
		return estado.siguienteTurno();
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
		estado.voltearCarta(carta);
	}
	
	public void aplicarMagica(Magica magica) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio, ExcepcionFaseIncorrecta {
		estado.aplicarMagica(magica);
	}
	
	public void atacarCon(Monstruo atacante, Monstruo defensor) throws ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		estado.atacarCon(atacante, defensor);
	}
	
	public Jugador ganador() throws ExcepcionJuegoNoTermino {
		return estado.devolverGanador(); 
	}
	
}
