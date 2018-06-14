package modelo.general;

import modelo.cartas.Carta;
import modelo.cartas.magica.Magica;
import modelo.cartas.monstruo.Monstruo;
import modelo.cartas.trampa.Trampa;
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
		return vida;
	}
	
	public void jugarCartaMagicaBocaAbajo(Magica cartaMagica){
		cartaMagica.colocarBocaAbajo(tablero);
	}
	
	public void jugarCartaTrampaBocaAbajo(Trampa cartaTrampa) {
		cartaTrampa.colocarBocaArriba(tablero);
	}
	
	public void jugarCartaTrampaBocaArriba(Trampa cartaTrampa) {
		cartaTrampa.colocarBocaArriba(tablero);
	}
	
	public void jugarCartaMonstruoBocaAbajo(Monstruo cartaMonstruo) {
		cartaMonstruo.colocarBocaAbajo(tablero);
	}
	
	public void voltearCarta(Carta carta) {
		carta.voltear();
	}
	
	public boolean cartaFueDestruida(Carta carta) {
		return tablero.estaEnCementerio(carta);
	}
	
	public void destruirMonstruo(Monstruo monstruo) {
		tablero.destruirCarta(monstruo);
	}

	public void atacar(Monstruo monstruoAtacante, Monstruo monstruoRival) throws ExcepcionMonstruoNoPuedeAtacar {
		
		Batalla batalla = new Batalla(this, oponente);
		
		batalla.atacarCon(monstruoAtacante, monstruoRival);
	}
	
	public void infligirDanio(double danio) {
		this.vida -= Math.abs(danio);
	}
}
