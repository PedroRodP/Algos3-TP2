package modelo.cartas.monstruo;

import modelo.general.Jugador;

public class ModoAtaque implements ModoDeCombate {
	
	private double puntajeAtaque;
	
	public ModoAtaque(double puntajeAtaque) {
		
		this.puntajeAtaque = puntajeAtaque;
	}
	
	@Override
	public double potencia() {
		return this.puntajeAtaque;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) {
		return puntajeAtaque - monstruo.potenciaDeCombate();
	}

	@Override
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		jugador.infligirDanio(danio);
	}
}