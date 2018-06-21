package modelo.tablero;

import org.junit.Test;

import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.trampa.Trampa;
import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Tablero;

public class TableroTest {

	@Test
	public void test01MandarCartaAlCementerioPoneCartaEnCementerio() throws ExcepcionZonaCompleta{
		
		Tablero tablero = new Tablero();
		Monstruo monstruo = new AgresorOscuro();
		
		tablero.agregarCarta(monstruo);
		tablero.destruirCarta(monstruo);
		
		assert (tablero.cartaEstaEnCementerio(monstruo));
	}
	
	@Test
	(expected = ExcepcionZonaCompleta.class)
	public void test02AgregarMasDe5MonstruosLanzaExcepcionZonaCompleta() throws ExcepcionZonaCompleta {
		
		Tablero tablero = new Tablero();
		Monstruo monstruo = new AgresorOscuro();
		
		for (int i = 0; i <= 5; i++) { //Iterara 6 veces
			tablero.agregarCarta(monstruo);
		}
	}
	
	@Test
	(expected = ExcepcionZonaCompleta.class)
	public void test03AgregarMasDe5TrampasOMagicasLanzaExcepcionZonaCompleta() throws ExcepcionZonaCompleta {
		
		Tablero tablero = new Tablero();
		Magica magica = new AgujeroNegro();
		Trampa trampa = new CilindroMagico();
		
		for (int i = 0; i < 3; i++) { //Iterara 3 veces
			tablero.agregarCarta(magica);
		}
		for (int j = 0; j < 3; j++) { //Iterara 3 veces
			tablero.agregarCarta(trampa);
		}
	}
}
