package modelo.cartas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.cartas.monstruo.Monstruo;

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

}
