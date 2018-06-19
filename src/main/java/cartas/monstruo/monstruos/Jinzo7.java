package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class Jinzo7 extends Monstruo {
    public Jinzo7() {
        super(500, 400, 2);
    }

    public void activarEfectoA(Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {

        this.atacarDirectoAJugador(jugador);
    }
}
