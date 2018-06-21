package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.monstruos.exodia.Exodia;

public class Mano {
	
	private int cantidad;
	private LinkedList<Carta> cartas;
	
	public Mano() {
		
		this.cantidad = 0;
		this.cartas = new LinkedList<Carta>();
	}
	
	public void agregar(Carta carta) {
		
		this.cartas.add(carta);
		this.cantidad++;
	}
	
	public boolean completoExodia() {
		return Exodia.estaCompleto(cartas);
	}
	
	public int cantidadDeCartas() {
		return this.cantidad;
	}

}
