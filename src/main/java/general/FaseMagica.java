package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class FaseMagica implements Fase {

	@Override
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		throw new ExcepcionJuegoNoTermino();
	}

	@Override
	public Fase proxima() throws ExcepcionTurnoFinalizo {
		throw new ExcepcionTurnoFinalizo();
	}
	
	@Override
	public void ejecutar(Jugador jugador) {
		//TODO Definir este metodo
		//jugador.jugarMagica(magica)...
	}

}
