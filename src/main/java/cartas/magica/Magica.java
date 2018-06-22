package main.java.cartas.magica;

import main.java.cartas.Carta;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.excepciones.ExcepcionZonaCompleta;

public abstract class Magica extends Carta{
	
	public void agregarseEn(ZonaMagicasYTrampas zona) throws ExcepcionZonaCompleta {
		this.lugar = zona;
		zona.agregar(this);
	}
	
}
