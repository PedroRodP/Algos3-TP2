package modelo.cartas;

import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.general.Jugador;

import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.trampa.Trampa;

import static org.junit.Assert.assertEquals;

public class TrampaTest {
    
    @Test
    public void test02SiColocaUnaCartaTrampaBocaAbajoEnTableroNoSeActivaEfecto() {
    	
    	Monstruo monstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        
        oponente.jugarCartaBocaAbajo(monstruo);
        jugador.jugarCartaBocaAbajo(trampa);

        assert (! oponente.cartaFueDestruida(monstruo));
    }
    
    

}
