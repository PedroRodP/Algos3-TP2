package modelo.cartas;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.campo.campos.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.Ansatsu;
import main.java.cartas.monstruo.monstruos.BestiaDeTalwar;
import main.java.cartas.monstruo.monstruos.BrujaOscura;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;
import main.java.general.Jugador;

public class CampoTest {
		
	private static final double DELTA = 1e-2;
	
	@Test
	public void testWastelandIncrementaElAtaqueEn200PuntosDeMonstruosPropiosY300LaDefensaDeMonstruosRivales() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionZonaIncorrecta {

   	 	Jugador jugador= new Jugador();
        Jugador oponente= new Jugador();
        
        Monstruo monstruoA = new AgresorOscuro();
        Monstruo monstruoB = new AgresorOscuro();
        Wasteland wasteland = new Wasteland();
        
        jugador.establecerOponente(oponente);
        oponente.establecerOponente(jugador);
       
        jugador.jugarCartaBocaArriba(monstruoA);
        oponente.jugarCartaBocaArriba(monstruoB);
        
        monstruoA.colocarEnAtaque();
        monstruoB.colocarEnDefensa();
        
        jugador.jugarCartaBocaArriba(wasteland);
        jugador.atacar(monstruoA, monstruoB);
        
        /*2 Agresores Oscuros tienen igual diferencia de combate,
         * pero Wasteland genera una diferencia de 100 puntos
         */
        assertEquals(8000 - 100, jugador.obtenerPuntosDeVida(), DELTA);
        
	}
	
	@Test
	public void testSogenIncrementaLaDefensaDeLosMonstruosPropiosEn500PuntosY200ElAtaqueDeMonstruosRivales() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionZonaIncorrecta {

   	 	Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        Monstruo monstruoA = new AgresorOscuro();
        Monstruo monstruoB = new AgresorOscuro();
        Sogen sogen = new Sogen();
        
        jugador.establecerOponente(oponente);
        oponente.establecerOponente(jugador);
        
        jugador.jugarCartaBocaArriba(monstruoA);
        oponente.jugarCartaBocaArriba(monstruoB);
        
        monstruoA.colocarEnDefensa();
        monstruoB.colocarEnAtaque();

        jugador.jugarCartaBocaArriba(sogen);
        
        oponente.atacar(monstruoB, monstruoA);
        
        //2 Agresores Oscuros no deberian tener diferencia de combate, pero Sogen genera una diferencia de 300
        assertEquals(8000 - 300, oponente.obtenerPuntosDeVida(), DELTA);
	}
	
	@Test
	public void testCuandoActivarEfectoSogenMonstruosPropiosAumentanLaDefensaYOponentesElAtaqueYCuandoDesactivoVuelveAlEstadoInicial() {
        Monstruo monstruoA = new AgresorOscuro();  //Defensa del agresor oscuro es 1200
        Monstruo monstruoB = new BestiaDeTalwar();  //Defensa de la bestia de talwar es 2150
        
        Monstruo monstruoC = new BrujaOscura(); //Ataque de la bruja oscura es 1800
        monstruoC.colocarEnAtaque();
        Monstruo monstruoD = new Ansatsu(); //Ataque de Ansatsu es 1700
        monstruoD.colocarEnAtaque();
        
        LinkedList<Monstruo> monstruosPropios = new LinkedList<Monstruo>();
        monstruosPropios.add(monstruoA); monstruosPropios.add(monstruoB);
        
        LinkedList<Monstruo> monstruosRivales = new LinkedList<Monstruo>();
        monstruosRivales.add(monstruoC); monstruosRivales.add(monstruoD);
        
        Sogen sogen = new Sogen();
        sogen.activarEfecto(monstruosPropios, monstruosRivales);
        
        
        assertEquals(1200 + 500, monstruoA.potenciaDeCombate(), DELTA);
        assertEquals(2150 + 500, monstruoB.potenciaDeCombate(), DELTA);
        
        assertEquals(1800 + 200, monstruoC.potenciaDeCombate(), DELTA);
        assertEquals(1700 + 200, monstruoD.potenciaDeCombate(), DELTA);
        
        
        sogen.desactivarEfecto(monstruosPropios, monstruosRivales);
        
        
        assertEquals(1200, monstruoA.potenciaDeCombate(), DELTA);
        assertEquals(2150, monstruoB.potenciaDeCombate(), DELTA);
        
        assertEquals(1800, monstruoC.potenciaDeCombate(), DELTA);
        assertEquals(1700, monstruoD.potenciaDeCombate(), DELTA);
	}
	
	@Test
	public void testCuandoActivarEfectoWastelandMonstruosPropiosAumentanElAtaqueYOponentesLaDefensaYCuandoDesactivoVuelveAlEstadoInicial() {
		
		 	Monstruo monstruoA = new AgresorOscuro();  //Ataque del agresor oscuro es 1200
	        Monstruo monstruoB = new BestiaDeTalwar();  //Ataque de la bestia de talwar es 2400
	        monstruoA.colocarEnAtaque();
	        monstruoB.colocarEnAtaque();
	        
	        Monstruo monstruoC = new BrujaOscura(); //Defensa de la bruja oscura es 1700
	        Monstruo monstruoD = new Ansatsu(); //Defensa de Ansatsu es 1200
	        
	        Wasteland w = new Wasteland();
	        
	        LinkedList<Monstruo> monstruosPropios = new LinkedList<Monstruo>();
	        monstruosPropios.add(monstruoA); monstruosPropios.add(monstruoB);
	        
	        LinkedList<Monstruo> monstruosRivales = new LinkedList<Monstruo>();
	        monstruosRivales.add(monstruoC); monstruosRivales.add(monstruoD);
	        
	        w.activarEfecto(monstruosPropios, monstruosRivales);
	        
	        assertEquals(1200 + 200, monstruoA.potenciaDeCombate(), DELTA);
	        assertEquals(2400 + 200, monstruoB.potenciaDeCombate(), DELTA);
	        
	        assertEquals(1700 + 300, monstruoC.potenciaDeCombate(), DELTA);
	        assertEquals(1200 + 300, monstruoD.potenciaDeCombate(), DELTA);
	        
	        w.desactivarEfecto(monstruosPropios, monstruosRivales);
	        
	        assertEquals(1200, monstruoA.potenciaDeCombate(), DELTA);
	        assertEquals(2400, monstruoB.potenciaDeCombate(), DELTA);
	        
	        assertEquals(1700, monstruoC.potenciaDeCombate(), DELTA);
	        assertEquals(1200, monstruoD.potenciaDeCombate(), DELTA);
		}
}
	
