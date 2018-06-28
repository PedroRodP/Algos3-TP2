package main.java.cartas.trampa.trampas;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.general.Jugador;

public class Reinforcement extends Trampa {

    @Override
    public void aplicarA(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor) {
        defensor.alterarAtaque(500);
        this.mandarAlCementerio();
    }

    @Override
    public void desactivarEfecto(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor) {
        defensor.alterarAtaque(-500);
    }
}
