package modelo.cartas.trampa;

import modelo.cartas.Carta;
import modelo.tablero.Tablero;

public class Trampa extends Carta{



    public  Trampa(String unNombre) {
        super(unNombre);
    }

    @Override
    public void agregarEn(Tablero unTablero) {
        unTablero.agregarEnZonaDeCartasTrampa(this);
    }
}
