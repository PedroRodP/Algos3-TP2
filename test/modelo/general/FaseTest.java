package modelo.general;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.InsectoComeHombres;
import main.java.excepciones.ExcepcionAlGoOh;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.general.Fase;
import main.java.general.FaseAtaque;
import main.java.general.FaseMagica;
import main.java.general.Jugador;

public class FaseTest {

	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaArribaEnFaseDistintaAPreparacionSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.jugarCartaBocaArriba(new Sogen(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaAbajoEnFaseDistintaAPreparacionSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.jugarCartaBocaAbajo(new Sogen(), new Jugador());
	}
	
	@Test
	public void cuandoVoltearCartaEnFasePreparacionCartaEstaBocaArribaEsTrue() throws ExcepcionFaseIncorrecta {
		Fase fase = new FaseMagica();
		Carta c = new AgresorOscuro();
		fase.voltearCarta(c, new Jugador());
		assert(c.estaBocaArriba());
	}
	
	@Test
	public void cuandoAplicarEfectoDeDeMonstruoInsectoComeHombresEnFaseAtaqueElMonstruoElegidoMuere() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		Jugador a = new Jugador();
		Jugador b = new Jugador();
		Monstruo insecto = new InsectoComeHombres();
		Monstruo m = new AgresorOscuro();
		a.jugarCartaBocaAbajo(insecto);
		b.jugarCartaBocaAbajo(m);
		fase.aplicarEfectoDeMonstruo(insecto, m, a);
		assert(m.estaEnElCementerio());
	}
	
}

