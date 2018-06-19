package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

public abstract class Trampa extends Carta{

    public void colocarEn(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
    
    public void aplicarEfectoA(Jugador jugador) {
		//Trampa no tiene efecto
	}
}
