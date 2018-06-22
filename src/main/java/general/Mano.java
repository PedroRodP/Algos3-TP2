package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.Lugar;
import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.exodia.Exodia;
import main.java.cartas.trampa.Trampa;

public class Mano implements Lugar {
	
	private int cantidad;
	private LinkedList<Carta> cartas;
	
	public Mano() {
		
		this.cantidad = 0;
		this.cartas = new LinkedList<Carta>();
	}
	
	public void agregar(Monstruo monstruo) {
		cartas.add(monstruo);
	}
	
	public void agregar(Magica magica) {
		cartas.add(magica);
	}
	
	public void agregar(Trampa trampa) {
		cartas.add(trampa);
	}
	
	public void agregar(Campo campo) {
		cartas.add(campo);
	}
	
	public void agregar(Carta carta) {
		
		this.cartas.add(carta);
		this.cantidad++;
	}
	
	public void remover(Carta carta) {
		
		this.cartas.remove(carta);
		this.cantidad--;
	}
	
	public boolean completoExodia() {
		return Exodia.estaCompleto(cartas);
	}
	
	public int cantidadDeCartas() {
		return this.cantidad;
	}

}
