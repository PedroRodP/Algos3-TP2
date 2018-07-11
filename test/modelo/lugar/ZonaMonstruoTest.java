package modelo.lugar;

import org.junit.Test;

import main.java.cartas.Cementerio;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.campo.Campo;
import main.java.cartas.campo.campos.Wasteland;
import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.AgujeroNegro;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.AgujaAsesina;
import main.java.cartas.trampa.Trampa;
import main.java.cartas.trampa.trampas.CilindroMagico;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaMonstruoTest {
	
	@Test
	(expected = ExcepcionZonaIncorrecta.class)
	public void test01CuandoIntentoAgregarCartaMagicaEnZonaMonstruosSeLanzaExcepcionZonaIncorrecta() throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		Magica magica = new AgujeroNegro();
		ZonaMonstruos zona = new ZonaMonstruos(new Cementerio());
		zona.agregar(magica);
	}
	
	@Test
	(expected = ExcepcionZonaIncorrecta.class)
	public void test02CuandoIntentoAgregarCartaCampoEnZonaMonstruosSeLanzaExcepcionZonaIncorrecta() throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		Campo campo = new Wasteland();
		ZonaMonstruos zona = new ZonaMonstruos(new Cementerio());
		zona.agregar(campo);
	}
	
	@Test
	(expected = ExcepcionZonaCompleta.class)
	public void test03CuandoIntentoAgregarCartaYLaZonaYaContiene5MonstruosSeLanzaExcepcionZonaCompleta() throws ExcepcionZonaCompleta {
		Monstruo monstruo = new AgujaAsesina();
		ZonaMonstruos zona = new ZonaMonstruos(new Cementerio());
		for (int i = 0; i < 5; i++) {
			zona.agregar(monstruo);
		}
		Monstruo m = new AgresorOscuro(); //Este voy a querer agregar y la zona esta llena
		zona.agregar(m);
	}
	
}
