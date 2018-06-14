package modelo.cartas.monstruo;

import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.general.Jugador;

public class ModoDefensa implements ModoDeCombate {
	
	private double valor;
	
	public ModoDefensa(double valor) {
		
		this.valor = valor;
	}
	
	@Override
	public double valor() {
		return this.valor;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}

	@Override
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		//No inflige danio por estar en modo defensa
	}
}
