package main.java.cartas.trampa.trampas;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.general.Jugador;

public class CilindroMagico  extends Trampa {

    public CilindroMagico(){
        nombre = "Cilindro Magico";
    }

    @Override
    public void aplicarA(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor) {
            jugador.quitarVida(atacante.obtenerAtaque());
    }
    
 /*   public void aplicarA(Monstruo atacante, Jugador oponente) {
    	
        Double ataque = atacante.potenciaDeCombate();
        
        oponente.infligirDanio(ataque);
    }*/
}
