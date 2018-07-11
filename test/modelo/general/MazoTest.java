package modelo.general;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.general.Mazo;

public class MazoTest {
	
	@Test
	(expected = ExcepcionMazoVacio.class)
	public void test01SiSeSacanMasDe40CartasDelMazoSeLanzaExcepcionMazoVacio() throws ExcepcionMazoVacio {
		
		Mazo mazo = new Mazo();
		
		for (int i = 0; i <= 40; i++) { //Iterara 41 veces
			mazo.tomarCarta();
		}
	}
	
	@Test
	public void test02SePuedenSacarHasta40CartasDelMazo() throws ExcepcionMazoVacio {
		
		Mazo mazo = new Mazo();
		LinkedList<Carta> almacen = new LinkedList<>();
		
		for (int i = 0; i < 40; i++) { //Iterara 40 veces
			almacen.add(mazo.tomarCarta()); //Pasa Carta de Mazo a Almacen
		}
		
		assertEquals(40, almacen.size());
	}
	
	@Test
	public void test03CuandoCreoMazoCantidadDeCartasEnElMazoDevuelve39() {
		Mazo mazo = new Mazo();
		assertEquals(40, mazo.obtenerCantidadCartas());
	}
	
	@Test
	public void test03CuandoCreoMazoYTomoUnaCartaCantidadDeCartasEnElMazoDevuelve39() throws ExcepcionMazoVacio {
		Mazo mazo = new Mazo();
		mazo.tomarCarta();
		assertEquals(39, mazo.obtenerCantidadCartas());
	}

}
