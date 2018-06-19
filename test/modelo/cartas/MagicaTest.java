package modelo.cartas;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.magica.magicas.OllaDeLaCodicia;
//import main.java.cartas.magica.magicas.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.Aitsu;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Jugador;
import main.java.general.Mazo;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

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
        agujeroNegro.aplicarEfectoA(jugadorA);

        assert(jugadorA.cartaFueDestruida(monstruoA));
        assert(jugadorA.cartaFueDestruida(monstruoB));
        assert (jugadorB.cartaFueDestruida(monstruoC));
        assertEquals(8000,jugadorA.vida(),DELTA);
        assertEquals(8000,jugadorB.vida(),DELTA);

    }
    
    @Test
    public void test03ActivarOllaDeLaCodiciaTomaDosCartasDelMazo() throws ExcepcionMazoVacio {
    	
    	OllaDeLaCodicia olla = new OllaDeLaCodicia();
    	Jugador jugador = new Jugador();
    	Monstruo monstruo1 = new Aitsu();
    	Monstruo monstruo2 = new Aitsu();
    	
    	LinkedList<Carta> cartas = new LinkedList<Carta>();
    	cartas.add(monstruo1);
    	cartas.add(monstruo2);
    	Mazo mazo = new Mazo(cartas);
    	
    	jugador.asignarMazo(mazo);
    	jugador.jugarCartaBocaArriba(olla);
    	olla.aplicarEfectoA(jugador);
    	
    	assertEquals (2, jugador.cantidadDeCartasEnMano());
    }
}
	

