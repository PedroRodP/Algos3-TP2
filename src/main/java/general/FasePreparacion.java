package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaNoNecesitaSacrificios;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class FasePreparacion extends Fase {

	@Override
	public String obtenerNombre() {
		return AlGoOh.FASE_PREPARACION;
	}

	@Override
	public Fase proxima() {
		return new FaseAtaque();
	}
	
	@Override
	public void jugarCartaBocaAbajo(Carta carta, Jugador jugador) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		jugador.jugarCartaBocaAbajo(carta);
	}
	
	@Override
	public void jugarCartaBocaArriba(Carta carta, Jugador jugador) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta {
		jugador.jugarCartaBocaArriba(carta);
	}
	
	@Override
	public void jugarSacrificandoBocaAbajo(Carta carta, LinkedList<Monstruo> sacrificados, Jugador jugador) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		jugador.jugarCartaBocaAbajoSacrificando(carta, sacrificados);
	}
	
	@Override
	public void jugarSacrificandoBocaArriba(Carta carta, LinkedList<Monstruo> sacrificados, Jugador jugador) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta {
		jugador.jugarCartaBocaArribaSacrificando(carta, sacrificados);
	}
	
	@Override
	public void voltearCarta(Carta carta, Jugador jugador) {
		jugador.voltearCarta(carta);
	}
	
	@Override
	public void colocarEnAtaque(Monstruo monstruo, Jugador jugador) {
		jugador.ponerEnAtaque(monstruo);
	}
	
	@Override
	public void colocarEnDefensa(Monstruo monstruo, Jugador jugador) {
		jugador.ponerEnDefensa(monstruo);
	}

}
