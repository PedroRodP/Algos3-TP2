package main.java.cartas.monstruo;

import main.java.general.Jugador;
import main.java.general.Vida;

public class ModoAtaque extends ModoDeCombate {
	
	public ModoAtaque(double puntajeAtaque) {
		
		this.puntaje = puntajeAtaque;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) {
		return this.puntaje - monstruo.potenciaDeCombate();
	}

	@Override
	public void quitarVida(Vida vida, double danio) {
		vida.quitar(Math.abs(danio));
	}

	
	public void actualizarPotencialDeAtaque(double puntos) {
		puntaje += puntos;
	}
	
	public void actualizarPotencialDeDefensa(double puntos) {	
		return;
	}
}
