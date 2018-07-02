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

public abstract class Fase {

	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		throw new ExcepcionJuegoNoTermino();
	}
	
	public abstract Fase proxima() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado;

	public void tomarCarta(Jugador jugador) throws ExcepcionFaseIncorrecta {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void jugarCartaBocaAbajo(Carta carta, Jugador jugador) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void jugarCartaBocaArriba(Carta carta, Jugador jugador) throws ExcepcionFaseIncorrecta, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados, Jugador jugador) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados, Jugador jugador) throws ExcepcionFaseIncorrecta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void voltearCarta(Carta carta, Jugador jugador) throws ExcepcionFaseIncorrecta {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void aplicarMagica(Magica magica, Jugador jugador) throws ExcepcionFaseIncorrecta, ExcepcionCartaBocaAbajo, ExcepcionMazoVacio {
		throw new ExcepcionFaseIncorrecta();
	}
	
	public void atacarCon(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		throw new ExcepcionFaseIncorrecta();
	}
}
