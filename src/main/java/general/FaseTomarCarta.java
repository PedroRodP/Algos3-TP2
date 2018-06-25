package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;

public class FaseTomarCarta implements Fase {
	
	@Override
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		throw new ExcepcionJuegoNoTermino();
	}
	
	@Override
	public Fase proxima() {
		return new FasePreparacion();
	}
	
	@Override
	public void ejecutar(Jugador jugador) {
		jugador.tomarCartaDelMazo();
	}
}