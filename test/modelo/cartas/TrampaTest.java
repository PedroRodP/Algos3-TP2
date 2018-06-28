package modelo.cartas;

import main.java.cartas.monstruo.monstruos.AbismoReluciente;
import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.cartas.trampa.trampas.Reinforcement;
import main.java.general.Jugador;

import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.trampa.Trampa;

import static org.junit.Assert.assertEquals;

public class TrampaTest {
    
	private final static double DELTA = 1e-2;
	
    @Test
    public void test01SiColocaUnaCartaTrampaBocaAbajoEnTableroNoSeActivaEfecto() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
    	
    	Monstruo monstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        
        oponente.jugarMonstruoBocaAbajo(monstruo);
        jugador.jugarTrampaBocaAbajo(trampa);

        assert (! monstruo.estaEnElCementerio());
    }
    
   @Test
    public void test02SiColocaUnaCartaTrampaBocaArribaEnTableroSeActivaEfecto() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionCartaBocaAbajo {
    	
    	Monstruo monstruo = new AgresorOscuro();
    	Monstruo miMonstruo = new AgresorOscuro();
        Trampa trampa = new CilindroMagico();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        jugador.establecerOponente(oponente);
        
        oponente.jugarMonstruoBocaArriba(monstruo);
        oponente.ponerEnAtaque(monstruo);
        
        jugador.jugarMonstruoBocaAbajo(miMonstruo);
        jugador.jugarTrampaBocaAbajo(trampa);
        
        oponente.atacar(monstruo, miMonstruo, trampa);
        
        assertEquals (8000 - 1200, oponente.obtenerPuntosDeVida(), DELTA);
        assert (!miMonstruo.estaEnElCementerio());
    }

    @Test
    public void test03CartaTrampaReinforcementAumentaEn500ElAtaqueDelDefensorYDestruyeAtacante() throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {

        Monstruo monstruo = new AbismoReluciente();
        Monstruo miMonstruo = new AgresorOscuro();
        Trampa trampa = new Reinforcement();
        Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();

        jugador.establecerOponente(oponente);

        oponente.jugarMonstruoBocaArriba(monstruo);
        oponente.ponerEnAtaque(monstruo);

        jugador.jugarMonstruoBocaArriba(miMonstruo);
        jugador.ponerEnAtaque(miMonstruo);
        jugador.jugarTrampaBocaAbajo(trampa);
        oponente.atacar(monstruo, miMonstruo, trampa);
        assertEquals(7900,oponente.obtenerPuntosDeVida(),DELTA);
        assert (monstruo.estaEnElCementerio());

    }
}
