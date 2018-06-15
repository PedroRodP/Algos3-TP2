package modelo.cartas;

import modelo.general.Jugador;

public interface Efecto {

    public void aplicar(Jugador atacante, Jugador oponente);
}
