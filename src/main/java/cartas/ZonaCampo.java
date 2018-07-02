package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.campo.campos.NoCampo;

public class ZonaCampo extends Lugar{

	private Campo campo;
	private Cementerio cementerio;
	
	public ZonaCampo(Cementerio cementerio) {
		this.campo = new NoCampo();
		this.cementerio = cementerio;
	}

	public void agregar(Carta carta) {
		
		cementerio.agregar(this.campo);
		
		Campo campo = (Campo) carta;
		
		this.campo = campo;
	}

	public Campo obtenerCampo() {
		return campo;
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
