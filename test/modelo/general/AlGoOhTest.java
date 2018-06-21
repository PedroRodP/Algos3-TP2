package modelo.general;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.general.AlGoOh;
import main.java.general.Jugador;

public class AlGoOhTest {
	
	@Test
	public void test01SiNoHayCartasEnMazoJugadorPierde() throws ExcepcionJuegoNoTermino{
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.siguienteTurno();
		
		for (int i=0; i <= 40; i++) {
			juego.faseTomarCarta();
		}
		
		assertEquals(jugador, juego.ganador().obtenerOponente());
		
	}
	
	@Test
	public void test02SiNoHayCartasEnMazoJuegoTermina(){
		
		AlGoOh juego = new AlGoOh();
		juego.siguienteTurno();
		
		for (int i=0; i <= 40; i++) {
			juego.faseTomarCarta();
		}
		
		assert(!juego.estaEnProceso());
		
	}

}
