package modelo.cartas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.campo.campos.Wasteland;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Jugador;

public class CampoTest {
		
	private static final double DELTA = 1e-2;
	
	@Test
	public void testWastelandIncrementaElAtaqueEn200PuntosDeMonstruosPropiosY300LaDefensaDeMonstruosRivales() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {

   	 	Jugador jugador= new Jugador();
        Jugador oponente= new Jugador();
        
        Monstruo monstruoA = new AgresorOscuro();
        Monstruo monstruoB = new AgresorOscuro();
       
        jugador.jugarMonstruoBocaArriba(monstruoA);
        oponente.jugarMonstruoBocaArriba(monstruoB);
        
        monstruoA.colocarEnAtaque();
        monstruoB.colocarEnDefensa();
        
        double ataqueMonstruoA = monstruoA.potenciaDeCombate();
        double defensaMonstruoB = monstruoB.potenciaDeCombate();
        
        Wasteland wasteland = new Wasteland();
        wasteland.afectaA(jugador.obtenerMonstruos(), oponente.obtenerMonstruos());
        
        jugador.jugarCampoBocaArriba(wasteland);
        
        assertEquals(ataqueMonstruoA + 200, monstruoA.potenciaDeCombate(), DELTA);
        assertEquals(defensaMonstruoB + 300, monstruoB.potenciaDeCombate(), DELTA);
	}
	
	@Test
	public void testSogenIncrementaElAtaqueDeLosMonstruosPropiosEn500PuntosY200ElAtaqueDeMonstruosRivales() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {

   	 	Jugador jugador = new Jugador();
        Jugador oponente = new Jugador();
        
        Monstruo monstruoA = new AgresorOscuro();
        monstruoA.colocarEnDefensa();
        Monstruo monstruoB = new AgresorOscuro();
        monstruoB.colocarEnAtaque();
       
        jugador.jugarMonstruoBocaArriba(monstruoA);
        
        oponente.jugarMonstruoBocaArriba(monstruoB);
        
        double defensaMonstruoA = monstruoA.potenciaDeCombate();
        double ataqueMonstruoB = monstruoB.potenciaDeCombate();
        
        Sogen sogen = new Sogen();
        sogen.afectaA(jugador.obtenerMonstruos(), oponente.obtenerMonstruos());
        
        jugador.jugarCampoBocaArriba(sogen);
        
        assertEquals(defensaMonstruoA + 500, monstruoA.potenciaDeCombate(), DELTA);
        assertEquals(ataqueMonstruoB + 200, monstruoB.potenciaDeCombate(), DELTA);
        
	}
		

}