package main.java.cartas;

import main.java.general.Jugador;

public interface Efecto {

    public void aplicar(Jugador atacante, Jugador oponente);
}
