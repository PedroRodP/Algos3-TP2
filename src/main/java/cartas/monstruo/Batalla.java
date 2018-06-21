package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class Batalla {
	
	private Jugador atacante;
	private Jugador oponente;
	
	public Batalla(Jugador atacante, Jugador oponente) {
		
		this.atacante = atacante;
		this.oponente = oponente;
	}
	
	public void atacarCon(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		double diferenciaDeCombate = monstruoAtacante.diferenciaDeCombateCon(monstruoRival);
		
		if (diferenciaDeCombate == 0) {
			atacante.destruirMonstruo(monstruoAtacante);
			oponente.destruirMonstruo(monstruoRival);
			
		} else if (diferenciaDeCombate < 0) {
				monstruoAtacante.infligirDanioAJugador(atacante, diferenciaDeCombate);
				atacante.destruirMonstruo(monstruoAtacante);
			
			} else {
				monstruoRival.infligirDanioAJugador(oponente, diferenciaDeCombate); //TODO no contempla el caso en q este en modo defensa 
				oponente.destruirMonstruo(monstruoRival); 
		}
	}
}
