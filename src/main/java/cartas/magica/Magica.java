package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public abstract class Magica extends Carta{
	
	public void agregarseEn(ZonaMagicasYTrampas zona) throws ExcepcionZonaCompleta {
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
