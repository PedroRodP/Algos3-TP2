package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class Jinzo7 extends Monstruo {
	
	Jugador oponente;
	
    public Jinzo7() {
        super(500, 400, 2);
        nombre = "Jinzo 7";
    }

    @Override
    public void atacar(Monstruo monstruoRival, Jugador atacante, Jugador oponente) {
    	
    	oponente.quitarVida(potenciaDeCombate());
    }
}
