package modelo.general;

import modelo.cartas.Carta;
import modelo.cartas.monstruo.Monstruo;
import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.tablero.Tablero;

public class Jugador {

	private double vida;
	private Tablero tablero;
	private Jugador oponente;
	
	public Jugador() {
		
		this.vida = 8000;
		this.tablero = new Tablero();
	}
	
	public void establecerOponente(Jugador oponente) {
		this.oponente = oponente;
	}
	
	public double vida() {
		return this.vida;
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar {
		
		Batalla batalla = new Batalla(this, oponente);
		
		batalla.atacarCon(monstruoAtacante, monstruoRival);
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
