package modelo.lugar;

import org.junit.Test;

import main.java.cartas.Cementerio;
import main.java.cartas.ZonaCampo;
import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaCampoTest {
	@Test
	(expected = ExcepcionZonaIncorrecta.class)
	public void test01CuandoIntentoAgregarMonstruoEnZonaCampoSeLanzaExcepcionZonaIncorrecta() throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		Monstruo monstruo = new AgresorOscuro();
		ZonaCampo zona = new ZonaCampo(new Cementerio());
		zona.agregar(monstruo);
	}
	
	@Test
	(expected = ExcepcionZonaIncorrecta.class)
	public void test02CuandoIntentoAgregarMagicaEnZonaCampoSeLanzaExcepcionZonaIncorrecta() throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		Magica magica = new AgujeroNegro();
		ZonaCampo zona = new ZonaCampo(new Cementerio());
		zona.agregar(magica);
	}
}
