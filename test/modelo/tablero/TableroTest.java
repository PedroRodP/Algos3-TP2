package modelo.tablero;

import org.junit.Test;

import modelo.cartas.monstruo.Monstruo;
import modelo.cartas.monstruo.monstruos.AgresorOscuro;

public class TableroTest {

	@Test
	public void test01MandarCartaAlCementerioPoneCartaEnCementerio() {
		
		Tablero tablero = new Tablero();
		Monstruo monstruo = new AgresorOscuro();
		
		tablero.agregarCarta(monstruo);
		tablero.destruirCarta(monstruo);
		
		assert (tablero.estaEnCementerio(monstruo));
	}
}
