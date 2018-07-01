package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public abstract class Magica extends Carta{
	
	public void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) throws ExcepcionZonaCompleta {
		this.lugar = zonaMagicasYTrampas;
		zonaMagicasYTrampas.agregar(this);
	}

	public void mandarAlCementerio(){
		try {
			lugar = lugar.quitarYAgregarAlCementerio(this);
		} catch (ExcepcionZonaIncorrecta excepcionZonaIncorrecta) {
			excepcionZonaIncorrecta.printStackTrace();
		}
	}
}
