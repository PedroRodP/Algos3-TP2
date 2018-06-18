package modelo.tablero;

import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.tablero.Tablero;

public class TableroTest {

	@Test
	public void test01MandarCartaAlCementerioPoneCartaEnCementerio() {
		
		Tablero tablero = new Tablero();
		Monstruo monstruo = new AgresorOscuro();
		
		tablero.agregarCarta(monstruo);
		tablero.destruirCarta(monstruo);
		
		assert (monstruo.estaEnCementerio());
	}
}
