package modelo.cartas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.campo.campos.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
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
		

}