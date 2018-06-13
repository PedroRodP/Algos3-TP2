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
			atacante.destruir(monstruoAtacante);
			oponente.destruir(monstruoRival);
			
		} else if (diferenciaDeCombate < 0) {
				monstruoAtacante.infligirDanioAJugador(atacante, diferenciaDeCombate);
				atacante.destruir(monstruoAtacante);
			
			} else {
				monstruoRival.infligirDanioAJugador(oponente, diferenciaDeCombate);
				oponente.destruir(monstruoRival);
			
		}
	}
}
