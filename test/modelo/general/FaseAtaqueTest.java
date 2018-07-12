package modelo.general;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.InsectoComeHombres;
import main.java.excepciones.ExcepcionAlGoOh;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.general.Fase;
import main.java.general.FaseAtaque;
import main.java.general.FaseMagica;
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
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void cuandoVoltearCartaSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		Jugador j = new Jugador();
		Carta c = new AgresorOscuro();
		j.jugarCartaBocaAbajo(c);
		fase.voltearCarta(c, j);
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoColocarEnAtaqueMonstruoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.colocarEnAtaque(new AgresorOscuro(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoColocarEnDefensaMonstruoSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.colocarEnDefensa(new AgresorOscuro(), new Jugador());
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void testCuandoSeIntentaAplicarEfectoDeMagicaSeLanzaExcepcionFaseIncorrecta() throws ExcepcionAlGoOh {
		Fase fase = new FaseAtaque();
		fase.aplicarMagica(new AgujeroNegro(), new Jugador());
	}
	
}

