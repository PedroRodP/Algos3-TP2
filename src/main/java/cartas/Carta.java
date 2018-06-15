package main.java.cartas;

import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.general.Cementerio;
import main.java.general.Jugador;
import main.java.general.NoCementerio;
import main.java.tablero.Tablero;

public abstract class Carta {
	
	protected Efecto efecto;
	protected final String nombre;
	protected Posicion posicion;
	protected Cementerio cementerio;

	protected Carta(String unNombre) {
		this.nombre = unNombre;
		this.posicion = new BocaAbajo();
		this.efecto = new SinEfecto();
		this.cementerio = new NoCementerio();
		
	}

	public abstract void colocarBocaAbajo(Tablero tablero);
    
    public abstract void colocarBocaArriba(Tablero tablero, Jugador atacante, Jugador oponente);
    
    public void activarEfecto() {
    	efecto.aplicar();
    }
    
    public void voltearCarta() {
    	posicion = new BocaArriba();
    	this.activarEfecto();
    }

	public boolean tenesEsteNombre(String unNombreCarta){
		return (this.nombre==unNombreCarta);
	};
	
	public void mandarAlCementerio() {
		cementerio = new Cementerio();
	}
	
	public boolean estaEnCementerio() {
		return cementerio.estaEnCementerio();
	}
}
