package main.java.general;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import main.java.cartas.Carta;
import main.java.excepciones.ExcepcionMazoVacio;

public class Mazo {

	private LinkedList<Carta> cartas;
	
	public Mazo(LinkedList<Carta> cartas) {
		
		this.cartas = cartas;
	}
	
	public Carta tomarCarta() throws ExcepcionMazoVacio {
		
		try {
			Carta carta = cartas.removeFirst();
			return carta;
			
		} catch (NoSuchElementException e) {
			throw new ExcepcionMazoVacio();
		}
	}
	
}
