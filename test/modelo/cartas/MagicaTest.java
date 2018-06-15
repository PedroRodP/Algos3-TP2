package modelo.cartas;

import org.junit.Test;

import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.general.Jugador;
import main.java.magica.Magica;
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
}
	

