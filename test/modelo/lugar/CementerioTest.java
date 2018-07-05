package modelo.lugar;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.Cementerio;
import main.java.cartas.campo.campos.Sogen;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.Ansatsu;
import main.java.cartas.monstruo.monstruos.BestiaAmfibia;
import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;

public class CementerioTest {

	@Test
	(expected = ExcepcionNoEsPosibleAgregarAlCementerio.class)
	public void test01CuandoQuitarYAgregarCartaAlCementerioSeLanzaExcepcionNoEsPosibleAgregarAlCementerio() {
		Cementerio cementerio = new Cementerio();
		cementerio.quitarYAgregarAlCementerio(new Sogen());
	}
	
	@Test
	public void test02CuandoAgregarMonstruosEnCementerioEsteContieneALosMonstruos() {
		Cementerio cementerio = new Cementerio();
		LinkedList<Monstruo> cartas = new LinkedList<>();
		Monstruo monstruoA = new BestiaAmfibia();
		Monstruo monstruoB = new AgresorOscuro();
		Monstruo monstruoC = new Ansatsu();
		cartas.add(monstruoA); cartas.add(monstruoB); cartas.add(monstruoC);
		cementerio.agregar(cartas);
	
		assert(cementerio.contiene(monstruoA) && cementerio.contiene(monstruoB) && cementerio.contiene(monstruoC));
	}
	
}
