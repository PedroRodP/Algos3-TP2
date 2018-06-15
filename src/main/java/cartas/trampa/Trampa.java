package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public class Trampa extends Carta{

    public  Trampa(String unNombre) {
        super(unNombre);
    }

    public void colocarBocaArriba(Tablero tablero, Jugador atacante, Jugador oponente) {
    	tablero.agregarCarta(this);
    	this.activarEfecto(atacante, oponente);
    }
    
    public void colocarBocaAbajo(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
}
