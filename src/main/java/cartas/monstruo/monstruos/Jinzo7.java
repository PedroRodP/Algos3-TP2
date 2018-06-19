package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class Jinzo7 extends Monstruo {
	
	Jugador oponente;
	
    public Jinzo7() {
        super(500, 400, 2);
    }
    
    public void afectaA(Jugador oponente) {
    	this.oponente = oponente;
    }

    public void aplicarEfecto(){
    	//todo si la carta esta boca abajo lanza excepcion..
    	this.infligirDanioAJugador(oponente, this.potenciaDeCombate());
    }
}
