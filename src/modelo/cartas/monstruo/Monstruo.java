package modelo.cartas.monstruo;

import modelo.cartas.Carta;

public class Monstruo implements Carta {

	private double ataque;
	private double defensa;
	private Posicion posicion;
	
	public Monstruo(double ataque, double defensa) {
		
		this.ataque = ataque;
		this.defensa = defensa;
	}
	
	public void colocarEnAtaque() {
		
		this.posicion = new Ataque(ataque);
	}
	
	public void colocarEnDefensa() {
		
		this.posicion = new Defensa(defensa);
	}
	
	public double vida() {
		
		return posicion.valor();
	}
}
