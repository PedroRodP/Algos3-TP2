package main.java.general;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;

public class FaseAtaque extends Fase {

	@Override
	public Fase proxima() {
		return new FaseMagica();
	}

	@Override
	public void atacarCon(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		jugador.atacar(atacante, defensor);
	}
}
