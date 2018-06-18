package main.java.cartas;

import main.java.general.Cementerio;
import main.java.general.NoCementerio;
import main.java.tablero.Tablero;

public abstract class Carta {
	
	protected Efecto efecto;
	protected String NOMBRE;
	protected Posicion posicion;
	protected Cementerio cementerio;

	protected Carta() {
		this.posicion = new BocaAbajo();
		this.efecto = new SinEfecto();
		this.cementerio = new NoCementerio();
		
	}

	public abstract void colocarBocaAbajo(Tablero tablero);
    
    public abstract void colocarBocaArriba(Tablero tablero);
    
    protected void activarEfecto() {
    	efecto.aplicar();
    }
    
    protected void voltear() {
    	posicion = new BocaArriba();
    	this.activarEfecto();
    }

	public boolean tenesEsteNombre(String unNombreCarta){
		return this.NOMBRE.equals(unNombreCarta);
	}
	
	public void mandarAlCementerio() {
		cementerio = new Cementerio();
	}
	
	public boolean estaEnCementerio() {
		return cementerio.estaEnCementerio();
	}
}
