package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaNoNecesitaSacrificios;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public class FasePreparacion extends Fase {

	@Override
	public Fase proxima() {
		return new FaseAtaque();
	}
	
	@Override
	public void jugarCartaBocaAbajo(Carta carta, Jugador jugador) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		jugador.jugarCartaBocaAbajo(carta);
	}
	
	@Override
	public void jugarCartaBocaArriba(Carta carta, Jugador jugador) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
		jugador.jugarCartaBocaArriba(carta);
	}
	
	@Override
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados, Jugador jugador) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios {
		jugador.jugarCartaBocaAbajoSacrificando(carta, sacrificados);
	}
	
	@Override
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados, Jugador jugador) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios {
		jugador.jugarCartaBocaArribaSacrificando(carta, sacrificados);
	}
	
	@Override
	public void voltearCarta(Carta carta, Jugador jugador) {
		jugador.voltearCarta(carta);
	}

}
