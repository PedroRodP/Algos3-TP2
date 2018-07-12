package modelo.general;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.excepciones.ExcepcionAlGoOh;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.general.Fase;
import main.java.general.FaseMagica;
import main.java.general.Jugador;

public class FaseMagicaTest {
	
	@Test
	public void cuandoVoltearCartaEnFasePreparacionCartaEstaBocaArribaEsTrue() throws ExcepcionFaseIncorrecta {
		Fase fase = new FaseMagica();
		Carta c = new AgresorOscuro();
		fase.voltearCarta(c, new Jugador());
		assert(c.estaBocaArriba());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaArribaSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseMagica();
		fase.jugarCartaBocaArriba(new Sogen(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaAbajoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseMagica();
		fase.jugarCartaBocaAbajo(new Sogen(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaAbajoSacrificandoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseMagica();
		fase.jugarSacrificandoBocaAbajo(new Sogen(), new LinkedList<Monstruo>(),  new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaArribaSacrificandoEnFaseAtaqueSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseMagica();
		fase.jugarSacrificandoBocaArriba(new Sogen(), new LinkedList<Monstruo>(),  new Jugador());
	}

}
