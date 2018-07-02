package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.campo.NoCampo;

public class ZonaCampo extends Lugar{

	private Campo campo;
	private Cementerio cementerio;
	
	public ZonaCampo(Cementerio cementerio) {
		this.campo = new NoCampo();
		this.cementerio = cementerio;
	}

	public void agregar(Carta carta) {
		Campo campo = (Campo) carta;
		this.campo.desactivarEfecto();
		cementerio.agregar(this.campo);
		this.campo = campo;
		this.campo.aplicarEfecto();
	}

	@Override
	public boolean esUnCementerio() {
		return false;
	}
	
	public Cementerio obtenerCementerio() {
		return cementerio;
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta){
		cementerio.agregar(campo);
		this.campo = new NoCampo();
	}
}
