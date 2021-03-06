package main.java.cartas.trampa.trampas;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class NoTrampa extends Trampa {
	
	public NoTrampa() {
		super();
	}
	
	@Override
	public void aplicarA(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
		atacante.atacar(defensor, jugador, jugador.obtenerOponente());
		//Esta carta no se destruye ya que no tiene un Lugar para estar, sino que se aplica cuando no hay Trampas
	}

}
