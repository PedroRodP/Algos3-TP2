package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.campo.NoCampo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaCampo extends Lugar{

	private Campo campo;
	private Cementerio cementerio;
	
	public ZonaCampo(Cementerio cementerio) {
		this.campo = new NoCampo();
		this.cementerio = cementerio;
	}

	public void agregar(Campo campo) {
		this.campo.desactivarEfecto();
		cementerio.agregar(this.campo);
		this.campo = campo;
		this.campo.aplicarEfecto();
	}

	@Override
	public boolean esUnCementerio() {
		return false;
	}

	@Override
	public Cementerio quitarYAgregarAlCementerio(Campo campo) throws ExcepcionZonaIncorrecta {
		cementerio.agregar(campo);
		this.campo = new NoCampo();
		return cementerio;
	}
}
