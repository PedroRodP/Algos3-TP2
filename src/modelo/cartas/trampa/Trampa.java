package modelo.cartas.trampa;

import modelo.Tablero.Tablero;
import modelo.cartas.Carta;

public class Trampa extends Carta{



    public  Trampa(String unNombre) {
        super(unNombre);
    }

    @Override
    public void agregarEn(Tablero unTablero) {
        unTablero.agregarEnZonaDeCartasTrampa(this);
    }
}
