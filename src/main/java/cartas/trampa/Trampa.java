package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;
import main.java.general.Jugador;

public abstract class Trampa extends Carta{
	
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

	public abstract void aplicarA(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar;
}
