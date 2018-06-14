package modelo.cartas;

import modelo.cartas.magica.Magica;
import modelo.cartas.monstruo.Monstruo;
import modelo.general.Jugador;
import modelo.tablero.Tablero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicaTest {

    private static final double DELTA = 1e-2;

    @Test
    public void test01ColocarUnaCartaMagiaEnCampo() {
    	
        Magica cartaMagica = new Magica("agujero negro");
        Tablero tablero= new Tablero();
        
        tablero.agregarCarta(cartaMagica);

        assertEquals(cartaMagica , tablero.obtenerCartaMagica("agujero negro"));
    }

    @Test

    public void test02CartaMagicaJugadaBocaAbajoEstaBocaArribaEsFalse(){
    	
    	Tablero tablero = new Tablero();
        Magica carta= new Magica("agujero negro");
        carta.colocarBocaAbajo(tablero);
        assertEquals(false,carta.estaBocaArriba());
    }

    @Test

    public void test03CartaAgujeroNegroDestruyeTodosLosMonstruosYNadieEsDaniado(){
        Efecto efecto= new Efecto();
        Magica cartaMagica= new Magica("agujero negro",efecto);
        Jugador jugador= new Jugador();
        Jugador oponente= new Jugador();
        Juego yugioh=Juego.obtenerJuego(jugador,oponente);
        Monstruo monstruoAzul = new Monstruo(1000, 500, 2, "dragon azul");
        Monstruo monstruoVerde = new Monstruo(1000, 1500, 2, "dragon verde");
        Monstruo monstruoRojo = new Monstruo(1000, 1500, 2, "dragon verde");

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
	

