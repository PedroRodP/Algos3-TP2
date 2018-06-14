package modelo.cartas.trampa;

import modelo.cartas.Carta;
import modelo.tablero.Tablero;

public class Trampa extends Carta{

    public  Trampa(String unNombre) {
        super(unNombre);
    }

    public void colocarBocaArriba(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
    
    public void colocarBocaAbajo(Tablero tablero) {
    	tablero.agregarCarta(this);
    }
}
