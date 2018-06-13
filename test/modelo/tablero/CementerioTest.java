package modelo.tablero;

import org.junit.Test;

import modelo.cartas.monstruo.Monstruo;

public class CementerioTest {
	
	@Test
	public void test01DestruirCartaVerificaQueSeEncuentraEnCementerio() {
		
		Monstruo carta = new Monstruo(1000, 500, "Banana");
		Tablero tablero = new Tablero();
		
		tablero.agregarEnZonaDeCartasMonstruo(carta);
		tablero.mandarAlCementerio(carta);
		
		assert tablero.estaEnCementerio(carta);
	}
}
