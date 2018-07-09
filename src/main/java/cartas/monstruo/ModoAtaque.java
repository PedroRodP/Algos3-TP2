package main.java.cartas.monstruo;

import main.java.general.Jugador;

public class ModoAtaque implements ModoDeCombate {
	
	private double puntaje;
	
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

	@Override
	public void actualizarPotencialDeAtaque(double puntos) {
		puntaje += puntos;
	}
	
	@Override
	public void actualizarPotencialDeDefensa(double puntos) {	
		//No hay defensa
	}

	@Override
	public double potencia() {
		return puntaje;
	}

	@Override
	public boolean estaEnDefensa() {
		return false;
	}
}
