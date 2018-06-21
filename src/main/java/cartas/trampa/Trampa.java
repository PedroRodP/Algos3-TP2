package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Jugador;
import main.java.general.Tablero;

public abstract class Trampa extends Carta{

    public void colocarEnTablero(Tablero tablero) throws ExcepcionZonaCompleta {
    	tablero.agregarCarta(this);
    }
    
    public void aplicarEfectoA(Jugador jugador) {
		//Trampa no tiene efecto
	}
}
