package main.java.general;

import java.util.LinkedList;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionMonstruoYaAtaco;

public class FaseAtaque extends Fase {

	LinkedList<Monstruo> atacantes = new LinkedList<>();
	
	@Override
	public Fase proxima() {
		return new FaseMagica();
	}

	@Override
	public void atacarCon(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		
		if (atacantes.contains(atacante)) throw new ExcepcionMonstruoYaAtaco();
		
		jugador.atacar(atacante, defensor);
		atacantes.add(atacante);
	}
	
	@Override
	public void aplicarEfectoDeMonstruo(Monstruo monstruo, Monstruo elegido, Jugador jugador) {
		
		jugador.aplicarEfectoDeMonstruo(monstruo, elegido);
	}
}
