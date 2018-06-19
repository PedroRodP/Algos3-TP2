package modelo.cartas;

import org.junit.Test;

import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
//import main.java.cartas.magica.magicas.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.general.Jugador;

import static org.junit.Assert.assertEquals;

public class MagicaTest {

    private static final double DELTA = 1e-2;

    @Test
    public void test01CartaMagicaJugadaBocaAbajoNoActivaEfecto(){
    	
    	Jugador jugadorA = new Jugador();
        Magica magica = new AgujeroNegro();
        Monstruo monstruo = new AgresorOscuro();
        
        jugadorA.jugarCartaBocaAbajo(monstruo);
        jugadorA.jugarCartaBocaAbajo(magica);
        
        assert (! jugadorA.cartaFueDestruida(monstruo));
    }

    @Test
    public void test02CartaAgujeroNegroDestruyeTodosLosMonstruosYNadieEsDaniado(){
    	
        Jugador jugadorA= new Jugador();
        Jugador jugadorB= new Jugador();
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        
        Monstruo monstruoA = new AgresorOscuro();
        Monstruo monstruoB = new AgresorOscuro();
        Monstruo monstruoC = new AgresorOscuro();
        
        jugadorA.establecerOponente(jugadorB);

        jugadorA.jugarCartaBocaAbajo(monstruoA);
        jugadorA.jugarCartaBocaAbajo(monstruoB);
        jugadorB.jugarCartaBocaAbajo(monstruoC);
        jugadorA.jugarCartaBocaArriba(agujeroNegro);

        assert(jugadorA.cartaFueDestruida(monstruoA));
        assert(jugadorA.cartaFueDestruida(monstruoB));
        assert (jugadorB.cartaFueDestruida(monstruoC));
        assertEquals(8000,jugadorA.vida(),DELTA);
        assertEquals(8000,jugadorB.vida(),DELTA);

    }
    
    /*@Test
    public void test03ActivarCartaMagicaWastelandAgrega200AlAtacanteY300AlDefensor() throws ExcepcionMonstruoNoPuedeAtacar {
    	
    	jugadorA atacante = new jugadorA();
    	jugadorA defensor = new jugadorA();
    	Monstruo monstruoAtacante = new AgresorOscuro();
    	Monstruo monstruoDefensor = new AgresorOscuro();
    	Magica wasteland = new Wasteland();
    	
    	atacante.establecerOponente(defensor);
    	atacante.jugarCartaBocaArriba(monstruoAtacante);
    	defensor.jugarCartaBocaArriba(monstruoDefensor);
    	monstruoAtacante.colocarEnAtaque();
    	monstruoDefensor.colocarEnAtaque();
    	
    	atacante.atacar(monstruoAtacante, monstruoDefensor);
    	atacante.jugarCartaBocaArriba(wasteland);
    }*/
}
	

