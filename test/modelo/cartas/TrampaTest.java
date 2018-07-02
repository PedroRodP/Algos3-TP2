package modelo.cartas;

import main.java.cartas.monstruo.monstruos.AbismoReluciente;
import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.excepciones.*;
import main.java.cartas.trampa.trampas.Reinforcements;
import main.java.general.Jugador;

import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.trampa.Trampa;

import static org.junit.Assert.assertEquals;

public class TrampaTest {
    
	private final static double DELTA = 1e-2;
	
    @Test
    public void test01SiColocaUnaCartaTrampaBocaAbajoEnTableroNoSeActivaEfecto() throws ExcepcionAlGoOh {
    	
    	Monstruo monstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        
        oponente.jugarCartaBocaAbajo(monstruo);
        jugador.jugarCartaBocaAbajo(trampa);

        assert (! monstruo.estaEnElCementerio());
    }
    
   @Test
    public void test02SiColocaUnaCartaTrampaBocaArribaEnTableroSeActivaEfecto() throws ExcepcionAlGoOh {
    	
    	Monstruo monstruo = new AgresorOscuro();
    	Monstruo miMonstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        oponente.establecerOponente(jugador);
        
        oponente.jugarCartaBocaArriba(monstruo);
        oponente.ponerEnAtaque(monstruo);
        
        jugador.jugarCartaBocaAbajo(miMonstruo);
        jugador.jugarCartaBocaAbajo(trampa);
        
        oponente.atacar(monstruo, miMonstruo);
        
        assertEquals (8000 - 1200, oponente.obtenerPuntosDeVida(), DELTA);
        assert (!miMonstruo.estaEnElCementerio());
    }

    @Test
    public void test03CartaTrampaReinforcementAumentaEn500ElAtaqueDelDefensorYDestruyeAtacante() throws ExcepcionAlGoOh {

        Monstruo monstruo = new AbismoReluciente();
        Monstruo miMonstruo = new AgresorOscuro();
        Trampa trampa = new Reinforcements();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();

        jugador.establecerOponente(oponente);
        oponente.establecerOponente(jugador);

        oponente.jugarCartaBocaArriba(monstruo);
        oponente.ponerEnAtaque(monstruo);

        jugador.jugarCartaBocaArriba(miMonstruo);
        jugador.ponerEnAtaque(miMonstruo);
        jugador.jugarCartaBocaAbajo(trampa);
        oponente.atacar(monstruo, miMonstruo);
        assertEquals(7900,oponente.obtenerPuntosDeVida(),DELTA);
        assert (monstruo.estaEnElCementerio());
        assertEquals(1200,miMonstruo.potenciaDeCombate(),DELTA);

    }
}
