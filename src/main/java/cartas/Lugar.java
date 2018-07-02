package main.java.cartas;

import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;
import main.java.excepciones.ExcepcionZonaCompleta;

public abstract class Lugar {
	
	public abstract void agregar(Carta carta) throws ExcepcionZonaCompleta;

	public abstract void quitarYAgregarAlCementerio(Carta carta) throws ExcepcionNoEsPosibleAgregarAlCementerio;

	public boolean esUnCementerio(){
	    return false;
    }
	
	public abstract Cementerio obtenerCementerio();

}
