package modelo.tablero;

import org.junit.Test;

import modelo.cartas.monstruo.Monstruo;

public class TableroTest {

	@Test
	public void test01MandarCartaAlCementerioPoneCartaEnCementerio() {
		
		Tablero tablero = new Tablero();
		Monstruo monstruo = new Monstruo(1000, 500,2, "dragon");
		
		tablero.agregarCarta(monstruo);
		tablero.destruirCarta(monstruo);
		
		assert (tablero.estaEnCementerio(monstruo));
	}
}
