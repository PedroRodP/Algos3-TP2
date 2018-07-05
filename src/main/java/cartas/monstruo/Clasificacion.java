package main.java.cartas.monstruo;

import java.util.LinkedList;

import main.java.cartas.ZonaMonstruos;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public class Clasificacion {
	
	private double cantidadDeEstrellas;
	
	public Clasificacion(int estrellas) {
		cantidadDeEstrellas = estrellas;
	}
	
	private int cantidadDeSacrificiosPorInvocacion() {
		if (cantidadDeEstrellas < 5) return 0;
		else if (cantidadDeEstrellas == 5) return 1;
		else return 2;
	}
	
	public void invocarSinSacrificios(Monstruo monstruo, ZonaMonstruos zona) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		if (cantidadDeSacrificiosPorInvocacion() != 0) throw new ExcepcionSacrificiosInsuficientes();
		zona.agregar(monstruo);
	}
	
	public void invocarConSacrificios(Monstruo monstruo, LinkedList<Monstruo> sacrificios, ZonaMonstruos zona) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		if (cantidadDeSacrificiosPorInvocacion() > sacrificios.size()) throw new ExcepcionSacrificiosInsuficientes();
		for (Monstruo m: sacrificios) m.mandarAlCementerio();
		zona.agregar(monstruo);
	}
	

}
