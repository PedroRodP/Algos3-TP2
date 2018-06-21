package modelo.general;

import org.junit.Test;

import main.java.general.Jugador;
import main.java.general.Mazo;


import static org.junit.Assert.assertEquals;

public class JugadorTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01CrearJugadorDevuelveJugadorCon8000PuntosDeVida() {
		
		Jugador jugador = new Jugador();

		assertEquals(8000, jugador.vida(), DELTA);
	}

	@Test
	public void test02JugadorPuedeTomarHasta40CartasDelMazo(){
		
		Jugador jugador = new Jugador();
		Mazo mazo = new Mazo();
		
		jugador.asignarMazo(mazo);
		
		for (int i = 0; i < 40; i++) { //Iterara 40 veces
			jugador.tomarCartaDelMazo();
		}
		
		assert(!jugador.seQuedoSinCartas());
	}
	
	@Test
	public void test02BISJugadorPuedeTomarHasta40CartasDelMazo(){
		
		Jugador jugador = new Jugador();
		Mazo mazo = new Mazo();
		
		jugador.asignarMazo(mazo);
		for (int i = 0; i < 50; i++) { 
			jugador.tomarCartaDelMazo();
		}
		
		assert(jugador.seQuedoSinCartas());
	}
}
