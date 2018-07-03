package modelo.general;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionMonstruoYaAtaco;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionTurnoFinalizo;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;
import main.java.general.AlGoOh;
import main.java.general.Jugador;

public class AlGoOhTest {
	
	@Test
	public void test01SiNoHayCartasEnMazoJugadorPierde() throws ExcepcionJuegoNoTermino {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.siguienteTurno();
		
		for (int i = 0; i <= 40; i++) { //41 veces, se acaba el mazo
			jugador.tomarCartaDelMazo();
		}
		
		assertEquals(jugador, juego.ganador().obtenerOponente());
		
	}
	
	@Test
	(expected = ExcepcionJuegoTerminado.class)
	public void test02SiNoHayCartasEnMazoJuegoTermina() throws ExcepcionJuegoTerminado, ExcepcionTurnoFinalizo {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.siguienteTurno();
		
		for (int i = 0; i <= 40; i++) {
			jugador.tomarCartaDelMazo();
		}
		
		//Intenta seguir jugando
		juego.pasarASiguienteFase();
	}
	
	@Test
	public void test03JugadorPuedeJugarCartaBocaArribaEnFasePreparacionYNoAtacarEnLaMismaFase() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta, ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.siguienteTurno();
		Monstruo ag = new AgresorOscuro();
		Monstruo def = new AgresorOscuro();
		
		juego.pasarASiguienteFase();
		
		juego.jugarCartaBocaArriba(ag);
		juego.colocarEnAtaque(ag);
		jugador.obtenerOponente().jugarCartaBocaAbajo(def);
		
		juego.pasarASiguienteFase();
		
		juego.atacarCon(ag, def);
		
		assertEquals (0, 0);
	}

}
