package main.java.cartas.trampa.trampas;

import main.java.cartas.Lugar;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class NoTrampa extends Trampa {
	
	public NoTrampa(Lugar zona) {
		this.lugar = zona;
	}
	
	@Override
	public void aplicarA(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
		atacante.atacar(defensor, jugador, jugador.obtenerOponente());
	}

}
