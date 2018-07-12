package modelo.general;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.AgujaAsesina;
import main.java.cartas.monstruo.monstruos.Aitsu;
import main.java.excepciones.ExcepcionAlGoOh;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.general.Fase;
import main.java.general.FasePreparacion;
import main.java.general.Jugador;

public class FasePreparacionTest {
	
	@Test
	public void test01CuandoVoltearCartaCartaEstaBocaArriba() throws ExcepcionFaseIncorrecta {
		Fase fase = new FasePreparacion();
		Carta c = new Sogen();
		fase.voltearCarta(c, new Jugador());
		assert(c.estaBocaArriba());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoSeIntentaAplicarEfectoDeMagicaSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FasePreparacion();
		fase.aplicarMagica(new AgujeroNegro(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoSeIntentaAplicarEfectoDeMonstruoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FasePreparacion();
		fase.aplicarEfectoDeMonstruo(new AgresorOscuro(), new AgresorOscuro(), new Jugador());
	}
	
	@Test
	public void testCuandoJugarBocaAbajoConSacrificiosLosMonstruosElegidosParaLaInvocacionVanAlCementerio() throws ExcepcionAlGoOh {
		Fase fase = new FasePreparacion();
		
		Jugador a = new Jugador();
		
		Monstruo monstruoA = new AgujaAsesina();
		Monstruo monstruoB = new AgresorOscuro();
		
		LinkedList<Monstruo> sacrificados = new LinkedList<>();
		
		fase.jugarCartaBocaAbajo(monstruoA, a);
		fase.jugarCartaBocaAbajo(monstruoB, a);
		
		sacrificados.add(monstruoA);
		sacrificados.add(monstruoB);
		
		fase.jugarSacrificandoBocaAbajo(new AgresorOscuro(), sacrificados, a);
		assert(monstruoA.estaEnElCementerio());
		assert(monstruoB.estaEnElCementerio());
	}
	
	@Test
	public void testCuandoJugarBocaArribaConSacrificiosLosMonstruosElegidosParaLaInvocacionVanAlCementerio() throws ExcepcionAlGoOh {
		Fase fase = new FasePreparacion();
		
		Jugador a = new Jugador();
		
		Monstruo monstruoA = new AgujaAsesina();
		Monstruo monstruoB = new AgresorOscuro();
		
		LinkedList<Monstruo> sacrificados = new LinkedList<>();
		
		fase.jugarCartaBocaArriba(monstruoA, a);
		fase.jugarCartaBocaArriba(monstruoB, a);
		
		sacrificados.add(monstruoA);
		sacrificados.add(monstruoB);
		
		fase.jugarSacrificandoBocaArriba(new AgresorOscuro(), sacrificados, a);
		assert(monstruoA.estaEnElCementerio());
		assert(monstruoB.estaEnElCementerio());
	}
	

}
