package modelo.cartas.monstruo;

import modelo.general.Jugador;

public class Ataque implements Modo {
	
	private double valor;
	
	public Ataque(double valor) {
		
		this.valor = valor;
	}
	
	@Override
	public double valor() {
		return this.valor;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) {
		return this.valor - monstruo.vida();
	}

	@Override
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		jugador.infligirDanio(danio);
	}
}
