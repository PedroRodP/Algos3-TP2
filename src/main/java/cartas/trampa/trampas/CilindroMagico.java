package main.java.cartas.trampa.trampas;

import main.java.cartas.trampa.Trampa;
import main.java.general.Jugador;

public class CilindroMagico  extends Trampa {

    public CilindroMagico(){
        nombre = "Cilindro Magico";
    }
    
    public void aplicarEfectoA(Jugador jugador) {
    	
    	//Monstruo atacante
        Jugador oponente = jugador.getOponente();
        //Double ataque = atacante.potenciaDeCombate();
        
        //oponente.infligirDanio(ataque);
    }

}
