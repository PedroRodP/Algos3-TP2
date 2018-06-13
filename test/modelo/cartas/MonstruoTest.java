package modelo.cartas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.cartas.monstruo.Monstruo;
import modelo.general.Jugador;

public class MonstruoTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ColocarUnMonstruoEnPosicionDeAtaqueUtilizaValorDeAtaque() {
		
		Monstruo monstruo = new Monstruo(1000, 500, "dragon"); //Ataque, defensa
		
		monstruo.colocarEnAtaque();
		
		assertEquals(1000, monstruo.vida(), DELTA);
	}
	
	@Test
	public void test02ColocarUnMonstruoEnPosicionDeDefensaUtilizaValorDeDefensa() {
		
		Monstruo monstruo = new Monstruo(1000, 500,"dragon azul");
		
		monstruo.colocarEnDefensa();
		
		assertEquals(500, monstruo.vida(), DELTA);
	}
	
	@Test
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() {
		
		Jugador jugador = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000,500,"dragon azul");
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new Monstruo(1100,500, "dragon verde");
		monstruoVerde.colocarEnAtaque();
		
		jugador.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000 - (1100-1000),jugador.vida(),DELTA);
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere() {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new Monstruo(1000,500,"dragon azul");
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new Monstruo(1100,500, "dragon verde");
		monstruoVerde.colocarEnAtaque();
		
		jugadorA.atacar(monstruoVerde,monstruoAzul);
		
		assertEquals(8000 - (1100-1000),jugadorB.vida(),DELTA);
	}

}
