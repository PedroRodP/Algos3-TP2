package modelo.cartas.monstruo;

import org.junit.Test;

import main.java.cartas.monstruo.ModoAtaque;
import main.java.cartas.monstruo.ModoDefensa;

public class ModoDeCombateTest {
	
	@Test
	public void testModoDefensaEstaEnDefensaDevuelveTrue() {
		ModoDefensa m = new ModoDefensa(300);
		assert(m.estaEnDefensa());
	}
	
	@Test
	public void testModoAtaqueEstaEnDefensaDevuelveFalse() {
		ModoAtaque m = new ModoAtaque(300);
		assert(! m.estaEnDefensa());
	}

}
