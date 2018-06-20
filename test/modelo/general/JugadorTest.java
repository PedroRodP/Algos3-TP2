package modelo.general;

import org.junit.Test;

import main.java.general.Jugador;


import static org.junit.Assert.assertEquals;

public class JugadorTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01CrearJugadorDevuelveJugadorCon8000PuntosDeVida() {
		
		Jugador jugador = new Jugador();

		assertEquals(8000, jugador.vida(), DELTA);
	}

}
