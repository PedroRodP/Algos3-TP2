package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.general.Jugador;
import main.java.general.Tablero;

public abstract class Trampa extends Carta{

    public void colocarEnTablero(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
    
    public void aplicarEfectoA(Jugador jugador) {
		//Trampa no tiene efecto
	}
}
