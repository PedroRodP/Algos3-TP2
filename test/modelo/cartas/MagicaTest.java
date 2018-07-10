package modelo.cartas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.magica.magicas.Fisura;
import main.java.cartas.magica.magicas.OllaDeLaCodicia;
//import main.java.cartas.magica.magicas.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.AmanteFeliz;
import main.java.excepciones.ExcepcionAlGoOh;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionZonaIncorrecta;
import main.java.general.Jugador;
import main.java.general.Mazo;

public class MagicaTest {

    private static final double DELTA = 1e-2;

    @Test
    public void test01CartaMagicaJugadaBocaAbajoNoActivaEfecto() throws ExcepcionAlGoOh{
    	
    	Jugador jugadorA = new Jugador();
        Magica magica = new AgujeroNegro();
        Monstruo monstruo = new AgresorOscuro();
        
        jugadorA.jugarCartaBocaAbajo(monstruo);
        jugadorA.jugarCartaBocaAbajo(magica);
        
        assert (! monstruo.estaEnElCementerio());
    }

    @Test
    public void test02CartaAgujeroNegroDestruyeTodosLosMonstruosYNadieEsDaniado() throws ExcepcionAlGoOh{
    	
        Jugador jugadorA= new Jugador();
        Jugador jugadorB= new Jugador();
        Magica agujeroNegro = new AgujeroNegro();
        
        Monstruo monstruoA = new AgresorOscuro();
        Monstruo monstruoB = new AgresorOscuro();
        Monstruo monstruoC = new AgresorOscuro();
        
        jugadorA.establecerOponente(jugadorB);

        jugadorA.jugarCartaBocaAbajo(monstruoA);
        jugadorA.jugarCartaBocaAbajo(monstruoB);
        jugadorB.jugarCartaBocaAbajo(monstruoC);
        jugadorA.jugarCartaBocaArriba(agujeroNegro);

        jugadorA.aplicarMagica(agujeroNegro);

        assert(monstruoA.estaEnElCementerio());
        assert(monstruoB.estaEnElCementerio());
        assert(monstruoC.estaEnElCementerio());
        assertEquals(8000,jugadorA.obtenerPuntosDeVida(),DELTA);
        assertEquals(8000,jugadorB.obtenerPuntosDeVida(),DELTA);

    }
    @Test
    public void test03ActivarOllaDeLaCodiciaTomaDosCartasDelMazo() throws ExcepcionAlGoOh{
    	
    	Magica olla = new OllaDeLaCodicia();
    	Jugador jugador = new Jugador();
    	Jugador oponente = new Jugador();
    	Mazo mazo = new Mazo();
    	
    	jugador.asignarMazo(mazo);
    	jugador.establecerOponente(oponente);
    	
    	jugador.jugarCartaBocaArriba(olla);
    	jugador.aplicarMagica(olla);
    	
    	assertEquals (2, jugador.cantidadDeCartasEnMano());
    }
    
    @Test
    public void test04CuandoActivarEfectoDeCartaMagicaFisuraSeDestruyeElMonstruoOponenteConMenorAtaque() throws ExcepcionAlGoOh{

    	Jugador jugador = new Jugador();
    	Jugador oponente = new Jugador();
    	
    	Magica fisura = new Fisura();
    
    	Monstruo agresorOscuro = new AgresorOscuro();
    	Monstruo amanteFeliz = new AmanteFeliz();
    	
    	jugador.establecerOponente(oponente);
    	
    	oponente.jugarCartaBocaArriba(agresorOscuro);
    	oponente.jugarCartaBocaArriba(amanteFeliz);
    	jugador.jugarCartaBocaArriba(fisura);
    	jugador.aplicarMagica(fisura);
    	
    	assert(amanteFeliz.estaEnElCementerio());
    	assert(! agresorOscuro.estaEnElCementerio());
    	
    }
    
    @Test
    (expected = ExcepcionCartaBocaAbajo.class)
    public void test05ActivarEfectoConCartaBocaAbajoLanzaExcepcion() throws ExcepcionAlGoOh{
    	
    	Jugador jugador = new Jugador();
    	AgujeroNegro magica = new AgujeroNegro();
    	
    	jugador.establecerOponente(new Jugador());
    	jugador.jugarCartaBocaAbajo(magica);

    	jugador.aplicarMagica(magica);
    }
    
   @Test
   (expected = ExcepcionCartaBocaAbajo.class)
   public void test05BISActivarEfectoConCartaBocaAbajoLanzaExcepcion() throws ExcepcionAlGoOh{
   	
	    Jugador jugador = new Jugador();
   		OllaDeLaCodicia magica = new OllaDeLaCodicia();
   	
   		jugador.establecerOponente(new Jugador());
   		jugador.jugarCartaBocaAbajo(magica);
   	
   		jugador.aplicarMagica(magica);
   }
   
   @Test
   (expected = ExcepcionCartaBocaAbajo.class)
   public void test05BISBISActivarEfectoConCartaBocaAbajoLanzaExcepcion() throws ExcepcionAlGoOh{
   	
	    Jugador jugador = new Jugador();
   		Fisura magica = new Fisura();
   	
   		jugador.establecerOponente(new Jugador());
   		jugador.jugarCartaBocaAbajo(magica);

   		jugador.aplicarMagica(magica);
   }

    @Test

    public void testDosFisuraDestruyenDosMonstruos() throws ExcepcionAlGoOh{

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Fisura magica = new Fisura();
        Fisura magica1 = new Fisura();
        AgresorOscuro monstruo = new AgresorOscuro();
        AgresorOscuro monstruo1 = new AgresorOscuro();

        jugador.establecerOponente(jugador2);
        jugador2.establecerOponente(jugador);

        jugador.jugarCartaBocaArriba(magica);
        jugador.jugarCartaBocaArriba(magica1);
        jugador2.jugarCartaBocaArriba(monstruo);
        jugador2.jugarCartaBocaArriba(monstruo1);

        jugador.aplicarMagica(magica);
        jugador.aplicarMagica(magica1);

        assert (monstruo.estaEnElCementerio());
        assert (monstruo1.estaEnElCementerio());

    }
}
	

