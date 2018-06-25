package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class ModoDefensa extends ModoDeCombate {
	
	public ModoDefensa(double puntajeDefensa) {
		
		this.puntaje = puntajeDefensa;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}

	@Override
	public void quitarVida(Jugador jugador, double danio) {
		//No inflige danio por estar en modo defensa
	}

	public void actualizarPotencialDeDefensa(double puntos) {
		puntaje += puntos;
	}
	
	public void actualizarPotencialDeAtaque(double puntos) {
		
	}

}
