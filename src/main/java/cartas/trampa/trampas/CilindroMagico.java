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
            this.mandarAlCementerio();
            throw new ErrorAtaqueDenegado();
    }

    @Override
    public void desactivarEfecto(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor) {

    }
    
 /*   public void aplicarA(Monstruo atacante, Jugador oponente) {
    	
        Double ataque = atacante.potenciaDeCombate();
        
        oponente.infligirDanio(ataque);
    }*/
}
