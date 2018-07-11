package modelo.cartas.monstruo;

import org.junit.Test;

import main.java.cartas.Cementerio;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Clasificacion;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public class ClasificacionTest {
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void testCuandoLaClasificacionMayorOIgualQue5SiIntentoInvocarSinSacrificiosSeLanzaExcepcionSacrificiosInsuficientes() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		Clasificacion c = new Clasificacion(6);
		
		c.invocarSinSacrificios(new AgresorOscuro(), new ZonaMonstruos(new Cementerio()));
	}

}
