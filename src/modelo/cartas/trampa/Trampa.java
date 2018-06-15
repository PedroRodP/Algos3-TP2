package modelo.cartas.trampa;

import modelo.cartas.Carta;
import modelo.general.Jugador;
import modelo.tablero.Tablero;

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
