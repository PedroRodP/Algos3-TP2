package modelo.cartas.monstruo;

import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.general.Jugador;

public interface Modo {

	public double valor();
	
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar;
	
	public void infligirDanioAJugador(Jugador jugador, double danio);
}