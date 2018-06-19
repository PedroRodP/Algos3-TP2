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
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		return; //No inflige danio por estar en modo defensa
	}
	
	@Override
	public void atacarDirectoAJugador(Jugador jugador) throws ExcepcionMonstruoNoPuedeAtacar{
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}
	
	public void actualizarPotencialDeDefensa(double puntos) {
		puntaje += puntos;
	}
	
	public void actualizarPotencialDeAtaque(double puntos) {
		
	}

}
