package main.java.cartas.trampa.trampas;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.general.Jugador;

public class CilindroMagico  extends Trampa {

    public CilindroMagico(){
    	super();
        nombre = "Cilindro Magico";
    }

    @Override
    public void aplicarA(Monstruo atacante, Monstruo defensor, Jugador jugador) {
    	jugador.quitarVida(atacante.obtenerAtaque());
    }
}
