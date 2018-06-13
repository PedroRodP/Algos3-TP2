package modelo.cartas.monstruo;

import modelo.cartas.Carta;
import modelo.tablero.Tablero;

public class Monstruo extends Carta {

	private double ataque;
	private double defensa;
	private Posicion posicion;
	
	public Monstruo(double ataque, double defensa,String unNombre) {
		super(unNombre);

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

	@Override
	public void agregarEn(Tablero unTablero) {
		unTablero.agregarEnZonaDeCartasMonstruo(this);
	}
}
