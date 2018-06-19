package modelo.cartas;

import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.general.Jugador;

import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.trampa.Trampa;

import static org.junit.Assert.assertEquals;

public class TrampaTest {
    
	private final static double DELTA = 1e-2;
	
    @Test
    public void test01SiColocaUnaCartaTrampaBocaAbajoEnTableroNoSeActivaEfecto() {
    	
    	Monstruo monstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        
        oponente.jugarCartaBocaAbajo(monstruo);
        jugador.jugarCartaBocaAbajo(trampa);

        assert (! oponente.cartaFueDestruida(monstruo));
    }
    
/*    @Test
    public void test02SiColocaUnaCartaTrampaBocaArribaEnTableroSeActivaEfecto() throws ExcepcionMonstruoNoPuedeAtacar {
    	
    	Monstruo monstruo = new AgresorOscuro();
    	Monstruo miMonstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        
        oponente.jugarCartaBocaArriba(monstruo);
        oponente.ponerEnAtaque(monstruo);
        
        jugador.jugarCartaBocaAbajo(miMonstruo);
        jugador.jugarCartaBocaAbajo(trampa);
        
        oponente.atacarConTrampa(monstruo, miMonstruo, trampa);
        
        assertEquals (8000 - 1200, oponente.vida(), DELTA);
    }*/
}
