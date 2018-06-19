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
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		jugador.infligirDanio(danio);
	}
		
	public void actualizarPotencialDeAtaque(double puntos) {
		puntaje += puntos;
	}
	
	public void actualizarPotencialDeDefensa(double puntos) {	
		return;
	}
	
	public void atacarDirectoAJugador(Jugador jugador) {
		jugador.infligirDanio(puntaje);
}
}
