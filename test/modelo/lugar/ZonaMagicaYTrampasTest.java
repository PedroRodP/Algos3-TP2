package modelo.lugar;

import org.junit.Test;

import main.java.cartas.Cementerio;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.campo.Campo;
import main.java.cartas.campo.campos.Wasteland;
import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.trampa.Trampa;
import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaMagicaYTrampasTest {

	
	@Test
	(expected = ExcepcionZonaIncorrecta.class)
	public void test01CuandoIntentoAgregarMonstruoEnZonaMagicaYTrampasSeLanzaExcepcionZonaIncorrecta() throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		Monstruo monstruo = new AgresorOscuro();
		ZonaMagicasYTrampas zona = new ZonaMagicasYTrampas(new Cementerio());
		zona.agregar(monstruo);
	}
	
	@Test
	(expected = ExcepcionZonaIncorrecta.class)
	public void test02CuandoIntentoAgregarCartaCampoEnZonaMagicaYTrampasSeLanzaExcepcionZonaIncorrecta() throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		Campo campo = new Wasteland();
		ZonaMagicasYTrampas zona = new ZonaMagicasYTrampas(new Cementerio());
		zona.agregar(campo);
	}
	
	@Test
	(expected = ExcepcionZonaCompleta.class)
	public void test03CuandoIntentoAgregarCartaYLaZonaYaContiene5CartasSeLanzaExcepcionZonaCompleta() throws ExcepcionZonaCompleta {
		Magica carta = new AgujeroNegro();
		ZonaMagicasYTrampas zona = new ZonaMagicasYTrampas(new Cementerio());
		for (int i = 0; i < 5; i++) {
			zona.agregar(carta);
		}
		Trampa trampa = new CilindroMagico();
		zona.agregar(trampa);
	}
}
