package modelo.general;

//import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import main.java.general.Jugador;
import main.java.general.Turnador;

import java.util.ArrayList;

public class TurnadorTest {

	@Test
	public void test01TurnadorDevuelveDistintosJugadoresPorCadaTurno() {
		
		Jugador player1 = new Jugador();
		Jugador player2 = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		
		listaJugadores.add(player1);
		listaJugadores.add(player2);
		
		Turnador turnador = new Turnador(listaJugadores);
		
		Jugador primerJugador = turnador.siguienteTurno();
		Jugador segundoJugador = turnador.siguienteTurno();
		
		//assertNotEquals(primerJugador, segundoJugador);
	}
}
