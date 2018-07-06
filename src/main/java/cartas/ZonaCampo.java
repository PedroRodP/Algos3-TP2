package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.campo.campos.NoCampo;

public class ZonaCampo extends Lugar{

	private Campo campo;
	private Cementerio cementerio;
	
	public ZonaCampo(Cementerio cementerio) {
		campo = new NoCampo();
		this.cementerio = cementerio;
	}

	public void agregar(Campo carta) {
		quitarYAgregarAlCementerio(campo);
		this.campo = carta;
		setChanged();
		notifyObservers();
	}

	public Campo obtenerCampo() {
		return campo;
	}
		
	public Cementerio obtenerCementerio() {
		return cementerio;
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta cartaCampo){
		cementerio.agregar((Carta) cartaCampo);
	}
}
