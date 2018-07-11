package modelo.lugar;

import org.junit.Test;

import main.java.cartas.campo.campos.Wasteland;
import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;
import main.java.general.Mano;

public class ManoTest {
	
	@Test
	(expected = ExcepcionNoEsPosibleAgregarAlCementerio.class)
	public void testCuandoQuitarYAgregarCartaAlCementerioDesdeLaManoSeLanzaExcepcionNoEsPosibleAgregarAlCementerio() {
		Mano mano = new Mano();
		mano.quitarYAgregarAlCementerio(new Wasteland());
	}

}
