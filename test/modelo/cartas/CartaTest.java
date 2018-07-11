package modelo.cartas;

import java.util.LinkedList;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.Cementerio;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.campo.campos.Sogen;
import main.java.excepciones.*;
import main.java.cartas.monstruo.Monstruo;

public class CartaTest {
	
	@Test
	(expected = ExcepcionCartaNoNecesitaSacrificios.class)
	public void test20cuandoQuieroAgregarUnaCartaAUnaZonaMonstruosConSacrificiosSeLanzaExcepcionCartaNoNecesitaSacrificios() throws ExcepcionAlGoOh {
		ZonaMonstruos zona = new ZonaMonstruos(new Cementerio());
		Carta carta = new Sogen();
		carta.agregarseEn(zona, new LinkedList<Monstruo>());
	}

}
