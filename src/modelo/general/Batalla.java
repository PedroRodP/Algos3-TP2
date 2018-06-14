package modelo.general;

import modelo.cartas.monstruo.Monstruo;
import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;

public class Batalla {
	
	private Jugador atacante;
	private Jugador oponente;
	
	public Batalla(Jugador atacante, Jugador oponente) {
		
		this.atacante = atacante;
		this.oponente = oponente;
	}
	
	public void atacarCon(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar {

		double diferenciaDeCombate = monstruoAtacante.diferenciaDeCombateCon(monstruoRival);
		
		if (diferenciaDeCombate == 0) {
			atacante.destruirMonstruo(monstruoAtacante);
			oponente.destruirMonstruo(monstruoRival);
			
		} else if (diferenciaDeCombate < 0) {
				monstruoAtacante.infligirDanioAJugador(atacante, diferenciaDeCombate);
				atacante.destruirMonstruo(monstruoAtacante);
			
			} else {
				monstruoRival.infligirDanioAJugador(oponente, diferenciaDeCombate);
				oponente.destruirMonstruo(monstruoRival);
			
		}
	}
}
