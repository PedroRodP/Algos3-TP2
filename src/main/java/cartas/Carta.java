package main.java.cartas;

import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public abstract class Carta {
	
	protected Efecto efecto;
	protected final String nombre;
	protected Posicion posicion;

	protected Carta(String unNombre) {
		this.nombre = unNombre;
		this.posicion = new BocaAbajo();
		this.efecto = new SinEfecto();
	}

	public abstract void colocarBocaAbajo(Tablero tablero);
    
    public abstract void colocarBocaArriba(Tablero tablero, Jugador atacante, Jugador oponente);
    
    public void activarEfecto(Jugador atacante, Jugador oponente) {
    	
    	try {
    		this.posicion = new BocaArriba();
    		this.posicion.aplicarEfecto(efecto, atacante, oponente);
    		
    	} catch (ExcepcionCartaBocaAbajo e) {
    		//BocaArriba nunca podria arrojar ExcepcionCartaBocaAbajo
    	}
    }

	public boolean tenesEsteNombre(String unNombreCarta){
		return (this.nombre==unNombreCarta);
	};
}
