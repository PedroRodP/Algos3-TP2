package main.java.cartas.trampa.trampas;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class Reinforcements extends Trampa {

    public Reinforcements(){
    	super();
        nombre = "Reinforcements";
    }

    @Override
    public void aplicarA(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
    	
    	defensor.alterarAtaque(500);
        atacante.atacar(defensor, jugador, jugador.obtenerOponente());
        defensor.alterarAtaque(-500);
        
        this.mandarAlCementerio();
    }
}
