package modelo.cartas;

import org.junit.Test;

import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.magica.magicas.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.Aitsu;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

import static org.junit.Assert.assertEquals;

public class MagicaTest {

    private static final double DELTA = 1e-2;

    @Test
    public void test01ColocarUnaCartaMagiaEnCampo() {
    	
        Magica cartaMagica = new AgujeroNegro();
        Tablero tablero= new Tablero();
        
        tablero.agregarCarta(cartaMagica);

        assertEquals(cartaMagica , tablero.obtenerCartaMagica("Agujero negro"));
    }

    @Test

    public void test02CartaMagicaJugadaBocaAbajoNoActivaEfecto(){
    	
    	Jugador atacante = new Jugador();
        Magica magica = new AgujeroNegro();
        Monstruo monstruo = new AgresorOscuro();
        
        atacante.jugarCartaBocaAbajo(monstruo);
        atacante.jugarCartaBocaAbajo(magica);
        
        assert (! atacante.cartaFueDestruida(monstruo));
    }

    @Test

    public void test03CartaAgujeroNegroDestruyeTodosLosMonstruosYNadieEsDaniado(){
    	
        Magica cartaMagica = new AgujeroNegro();
        Jugador jugador= new Jugador();
        Jugador oponente= new Jugador();
        Monstruo monstruoAzul = new AgresorOscuro();
        Monstruo monstruoVerde = new AgresorOscuro();
        Monstruo monstruoRojo = new AgresorOscuro();
        
        jugador.establecerOponente(oponente);

        jugador.jugarCartaBocaAbajo(monstruoAzul);
        jugador.jugarCartaBocaAbajo(monstruoVerde);
        oponente.jugarCartaBocaAbajo(monstruoRojo);
        jugador.jugarCartaBocaArriba(cartaMagica);

        assert(jugador.cartaFueDestruida(monstruoAzul));
        assert(jugador.cartaFueDestruida(monstruoVerde));
        assert (oponente.cartaFueDestruida(monstruoRojo));
        assertEquals(8000,jugador.vida(),DELTA);
        assertEquals(8000,oponente.vida(),DELTA);

    }
    
    /*@Test
    public void test04ActivarCartaMagicaWastelandAgrega200AlAtacanteY300AlDefensor() throws ExcepcionMonstruoNoPuedeAtacar {
    	
    	Jugador atacante = new Jugador();
    	Jugador defensor = new Jugador();
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
	

