package modelo.general;

import modelo.cartas.Carta;
import modelo.cartas.monstruo.Monstruo;
import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.tablero.Tablero;

public class Jugador {

	private double vida;
	private Tablero tablero = new Tablero();
	private Jugador oponente;
	
	public Jugador() {
		
		this.vida = 8000;
	}
	
	public void establecerOponente(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public double vida() {
		return this.vida;
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar {
		
		double diferenciaDeCombate = monstruoAtacante.atacar(monstruoRival);
		
		if (diferenciaDeCombate < 0) {
			monstruoAtacante.infligirDanioAJugador(this, diferenciaDeCombate);
		
		} else {
			monstruoRival.infligirDanioAJugador(oponente, diferenciaDeCombate);
	
		}
	}
	
	public void destruir(Carta carta) {
		tablero.mandarAlCementerio(carta);
	}
	
	public void infligirDanio(double danio) {
		this.vida -= Math.abs(danio);
	}
	
	public void colocarMonstruoEnModoAtaque(int posicionMonstruo) {
		Monstruo monstruo = tablero.obtenerMonstruo(posicionMonstruo);
		monstruo.colocarEnAtaque();
	}
	
	public void colocarMonstruoEnModoDefensa(int posicionMonstruo) {
		Monstruo monstruo = tablero.obtenerMonstruo(posicionMonstruo);
		monstruo.colocarEnDefensa();
	}
}
