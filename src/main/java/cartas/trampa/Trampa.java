package main.java.cartas.trampa;

import main.java.cartas.Carta;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;
import main.java.general.Jugador;

public abstract class Trampa extends Carta{

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

	public abstract void aplicarA(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor);


	public abstract void desactivarEfecto(Jugador jugador, Monstruo atacante, Jugador oponente, Monstruo defensor);
}
