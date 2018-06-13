package modelo.general;

import modelo.cartas.Carta;
import modelo.cartas.monstruo.Monstruo;
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

	public void atacar(int posicionMonstruoAtacante, int posicionMonstruoDefensor) {
		Monstruo monstruoAtacante = tablero.obtenerMonstruo(posicionMonstruoAtacante);
		oponente.recibirAtaque(monstruoAtacante, posicionMonstruoDefensor);
	}
	
	public void recibirAtaque(Monstruo monstruoAtacante, int posicionMonstruoDefensor) {
		Monstruo monstruoDefensor = tablero.obtenerMonstruo(posicionMonstruoDefensor);
		monstruoAtacante.atacar(monstruoDefensor);
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
