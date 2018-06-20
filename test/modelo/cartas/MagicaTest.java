package modelo.cartas;

import org.junit.Test;

import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.magica.magicas.Fisura;
import main.java.cartas.magica.magicas.OllaDeLaCodicia;
//import main.java.cartas.magica.magicas.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.Aitsu;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Jugador;
import main.java.general.Mazo;

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
        agujeroNegro.afectaA(jugadorA);
        agujeroNegro.aplicarEfecto();

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
    	Mazo mazo = new Mazo();
    	
    	jugador.asignarMazo(mazo);
    	jugador.jugarCartaBocaArriba(olla);
    	olla.afectaA(jugador);
    	olla.aplicarEfecto();
    	
    	assertEquals (2, jugador.cantidadDeCartasEnMano());
    }
    
    @Test
    public void test04CuandoActivarEfectoDeCartaMagicaFisuraSeDestruyeElMonstruoOponenteConMenorAtaque() {

    	Jugador oponente = new Jugador();
    	
    	Fisura fisura = new Fisura();
    
    	Monstruo agresorOscuro = new AgresorOscuro();
    	Monstruo aitsu = new Aitsu();
    	
    	oponente.jugarCartaBocaArriba(agresorOscuro);
    	oponente.jugarCartaBocaArriba(aitsu);
    	
    	fisura.afectaA(oponente);
    	fisura.aplicarEfecto();
    	
    	assert(oponente.cartaFueDestruida(aitsu));
    	assert(! oponente.cartaFueDestruida(agresorOscuro));
    	
    }
}
	

