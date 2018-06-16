package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public class Trampa extends Carta{

    public void colocarBocaArriba(Tablero tablero) {
    	tablero.agregarCarta(this);
    	this.voltearCarta();
    }
    
    public void colocarBocaAbajo(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
}
