package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;

public class FaseAtaque implements Fase {

	@Override
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		throw new ExcepcionJuegoNoTermino();
	}

	@Override
	public Fase proxima() {
		return new FaseMagica();
	}

	@Override
	public void ejecutar(Jugador jugador) {
		//TODO Definir este metodo
		//jugador.atacar(atacante, rival);
	}
}
