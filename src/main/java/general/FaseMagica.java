package main.java.general;

import main.java.cartas.Carta;
import main.java.cartas.magica.Magica;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class FaseMagica extends Fase {

	@Override
	public String obtenerNombre() {
		return AlGoOh.FASE_MAGICA;
	}

	@Override
	public Fase proxima() throws ExcepcionTurnoFinalizo {
		throw new ExcepcionTurnoFinalizo();
	}
	
	@Override
	public void voltearCarta(Carta carta, Jugador jugador) {
		jugador.voltearCarta(carta);
	}
	
	@Override
	public void aplicarMagica(Magica magica, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio {
		jugador.aplicarMagica(magica);
	}

}
