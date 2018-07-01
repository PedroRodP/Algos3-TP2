package modelo.cartas;

import main.java.cartas.ZonaMonstruos;
import org.junit.Test;

import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.magica.magicas.Fisura;
import main.java.cartas.magica.magicas.OllaDeLaCodicia;
//import main.java.cartas.magica.magicas.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.AmanteFeliz;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Jugador;
import main.java.general.Mazo;

import static org.junit.Assert.assertEquals;

public class MagicaTest {

    private static final double DELTA = 1e-2;

    @Test
    public void test01CartaMagicaJugadaBocaAbajoNoActivaEfecto() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta{
    	
    	Jugador jugadorA = new Jugador();
        Magica magica = new AgujeroNegro();
        Monstruo monstruo = new AgresorOscuro();
        
        jugadorA.jugarCartaBocaAbajo(monstruo);
        jugadorA.jugarCartaBocaAbajo(magica);
        
        assert (! monstruo.estaEnElCementerio());
    }

    @Test
    public void test02CartaAgujeroNegroDestruyeTodosLosMonstruosYNadieEsDaniado() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaBocaAbajo{
    	
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

        agujeroNegro.aplicarEfecto(jugadorA.obtenerMonstruos(),jugadorB.obtenerMonstruos());

        assert(monstruoA.estaEnElCementerio());
        assert(monstruoB.estaEnElCementerio());
        assert(monstruoC.estaEnElCementerio());
        assertEquals(8000,jugadorA.obtenerPuntosDeVida(),DELTA);
        assertEquals(8000,jugadorB.obtenerPuntosDeVida(),DELTA);

    }
    @Test
    public void test03ActivarOllaDeLaCodiciaTomaDosCartasDelMazo() throws ExcepcionMazoVacio, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaBocaAbajo {
    	
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
    public void test04CuandoActivarEfectoDeCartaMagicaFisuraSeDestruyeElMonstruoOponenteConMenorAtaque() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaBocaAbajo {

    	Jugador jugador = new Jugador();
    	Jugador oponente = new Jugador();
    	
    	Fisura fisura = new Fisura();
    
    	Monstruo agresorOscuro = new AgresorOscuro();
    	Monstruo amanteFeliz = new AmanteFeliz();
    	
    	jugador.establecerOponente(oponente);
    	
    	oponente.jugarCartaBocaArriba(agresorOscuro);
    	oponente.jugarCartaBocaArriba(amanteFeliz);
    	jugador.jugarCartaBocaArriba(fisura);
    	fisura.aplicarEfecto(oponente.obtenerMonstruos());
    	
    	assert(amanteFeliz.estaEnElCementerio());
    	assert(! agresorOscuro.estaEnElCementerio());
    	
    }
    
    @Test
    (expected = ExcepcionCartaBocaAbajo.class)
    public void test05ActivarEfectoConCartaBocaAbajoLanzaExcepcion() throws ExcepcionZonaCompleta, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes {
    	
    	Jugador jugador = new Jugador();
    	Jugador oponente = new Jugador();
    	jugador.establecerOponente(oponente);
        oponente.establecerOponente(jugador);

    	AgujeroNegro magica = new AgujeroNegro();
    	
    	jugador.jugarCartaBocaAbajo(magica);

    	magica.aplicarEfecto(jugador.obtenerMonstruos(),oponente.obtenerMonstruos());
    }
    
   @Test
   (expected = ExcepcionCartaBocaAbajo.class)
   public void test05BISActivarEfectoConCartaBocaAbajoLanzaExcepcion() throws ExcepcionZonaCompleta, ExcepcionCartaBocaAbajo, ExcepcionMazoVacio, ExcepcionSacrificiosInsuficientes {
   	
   		Jugador jugador = new Jugador();
   		OllaDeLaCodicia magica = new OllaDeLaCodicia();
   	
   		jugador.jugarCartaBocaAbajo(magica);
   	
   		magica.afectaA(jugador);
   		magica.aplicarEfecto();
   }
   
   @Test
   (expected = ExcepcionCartaBocaAbajo.class)
   public void test05BISBISActivarEfectoConCartaBocaAbajoLanzaExcepcion() throws ExcepcionZonaCompleta, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes {
   	
   		Jugador jugador = new Jugador();
   		Fisura magica = new Fisura();
   	
   		jugador.jugarCartaBocaAbajo(magica);

   		magica.aplicarEfecto(jugador.obtenerMonstruos());
   }
}
	

