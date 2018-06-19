package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public class Trampa extends Carta{

    public void colocarEn(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
    
    public void aplicarEfectoA(Jugador jugador) {
		//Trampa no tiene efecto
	}
}
