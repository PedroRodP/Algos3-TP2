package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class ModoDefensa implements ModoDeCombate {
	
	private double puntaje;
	
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

	@Override
	public void actualizarPotencialDeDefensa(double puntos) {
		puntaje += puntos;
	}
	
	@Override
	public void actualizarPotencialDeAtaque(double puntos) {
		//No hay ataque
	}

	@Override
	public double potencia() {
		return puntaje;
	}

}
