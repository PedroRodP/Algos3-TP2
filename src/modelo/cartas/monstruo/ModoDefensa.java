package modelo.cartas.monstruo;

import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.general.Jugador;

public class ModoDefensa implements ModoDeCombate {
	
	private double puntajeDefensa;
	
	public ModoDefensa(double puntajeDefensa) {
		
		this.puntajeDefensa = puntajeDefensa;
	}
	
	@Override
	public double potencia() {
		return puntajeDefensa;
	}
	
	@Override
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}

	@Override
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		return; //No inflige danio por estar en modo defensa
	}
}
