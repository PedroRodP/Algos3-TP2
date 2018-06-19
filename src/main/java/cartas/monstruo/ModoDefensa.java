package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class ModoDefensa implements ModoDeCombate {
	
	private double puntajeDefensa;
	
	public ModoDefensa(double puntajeDefensa) {
		
		this.puntajeDefensa = puntajeDefensa;
	}
	
	@Override
	public double potencia() {
		return puntajeDefensa;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}

	@Override
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		return; //No inflige danio por estar en modo defensa
	}

	@Override
	public void atacarDirectoAJugador(Jugador jugador) throws ExcepcionMonstruoNoPuedeAtacar {
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}
}
