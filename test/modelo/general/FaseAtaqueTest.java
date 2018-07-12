package modelo.general;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.InsectoComeHombres;
import main.java.excepciones.ExcepcionAlGoOh;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.general.Fase;
import main.java.general.FaseAtaque;
import main.java.general.Jugador;

public class FaseAtaqueTest {

	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaArribaSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.jugarCartaBocaArriba(new Sogen(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaAbajoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.jugarCartaBocaAbajo(new Sogen(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaAbajoSacrificandoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.jugarSacrificandoBocaAbajo(new Sogen(), new LinkedList<Monstruo>(),  new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoJugarCartaBocaArribaSacrificandoEnFaseAtaqueSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.jugarSacrificandoBocaArriba(new Sogen(), new LinkedList<Monstruo>(),  new Jugador());
	}
	
	@Test
	public void cuandoAplicarEfectoDeDeMonstruoInsectoComeHombresElMonstruoElegidoMuere() throws ExcepcionAlGoOh {
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

