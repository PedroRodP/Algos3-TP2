package main.java.cartas.campo;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public abstract class Campo extends Carta {
	
	protected LinkedList<Monstruo> monstruosPropios;
	protected LinkedList<Monstruo> monstruosRivales;
	
	public void afectaA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		this.monstruosPropios = monstruosPropios;
		this.monstruosRivales = monstruosRivales;
	}
	
	public abstract void aplicarEfecto();
	
	public abstract void desactivarEfecto();
	
	public void agregarseEn(ZonaCampo zona) {
		this.lugar = zona;
		zona.agregar(this);
	}

	public void mandarAlCementerio(){
		try {
			lugar = lugar.quitarYAgregarAlCementerio(this);
		} catch (ExcepcionZonaIncorrecta excepcionZonaIncorrecta) {
			excepcionZonaIncorrecta.printStackTrace();
		}
	}
}
