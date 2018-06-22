package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.campo.NoCampo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaCampo implements Lugar{

	private Campo campo;
	private Cementerio cementerio;
	
	public ZonaCampo(Cementerio cementerio) {
		this.campo = new NoCampo();
		this.cementerio = cementerio;
	}
	
	public void agregar(Monstruo monstruo) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Magica magica) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Trampa trampa) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Campo campo) {
		this.campo.desactivarEfecto();
		cementerio.agregar(this.campo);
		this.campo = campo;
		this.campo.aplicarEfecto();
	}
}
