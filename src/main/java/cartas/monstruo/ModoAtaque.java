package main.java.cartas.monstruo;

import main.java.general.Jugador;

public class ModoAtaque extends ModoDeCombate {
	
	public ModoAtaque(double puntajeAtaque) {
		
		this.puntaje = puntajeAtaque;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) {
		return this.puntaje - monstruo.potenciaDeCombate();
	}

	@Override
	public void quitarVida(Jugador jugador, double danio) {
		double danioAbsoluto = Math.abs(danio);
		jugador.quitarVida(danioAbsoluto);
	}

	
	public void actualizarPotencialDeAtaque(double puntos) {
		puntaje += puntos;
	}
	
	public void actualizarPotencialDeDefensa(double puntos) {	
		return;
	}
}
