package main.java.efectos;

import main.java.cartas.Efecto;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class EfectoCilindroMagico extends Efecto {

    private Monstruo atacante;
    private Jugador oponente;

    public void afectaA(Monstruo atacante, Jugador oponente){
        this.atacante = atacante;
        this.oponente = oponente;
    }

    @Override
    public void aplicar() {
        Double ataque = atacante.potenciaDeCombate();
        oponente.infligirDanio(ataque);
    }
}
