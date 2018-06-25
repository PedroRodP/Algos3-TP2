package modelo.general;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionTurnoFinalizo;
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
		juego.jugar();
	}

}
