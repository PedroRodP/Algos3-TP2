package main.java.general;

import main.java.cartas.Carta;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class FaseMagica extends Fase {

	@Override
	public Fase proxima() throws ExcepcionTurnoFinalizo {
		throw new ExcepcionTurnoFinalizo();
	}
	
	@Override
	public void voltearCarta(Carta carta, Jugador jugador) {
		jugador.voltearCarta(carta);
	}

}
