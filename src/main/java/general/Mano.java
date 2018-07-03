package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.Cementerio;
import main.java.cartas.Lugar;
import main.java.cartas.monstruo.monstruos.exodia.Exodia;
import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;

public class Mano extends Lugar {

	private LinkedList<Carta> cartas;
	
	public Mano() {
		this.cartas = new LinkedList<>();
	}

	public void agregar(Carta carta) {
		this.cartas.add(carta);
		setChanged();
		notifyObservers();
	}
	
	public void remover(Carta carta){
        this.cartas.remove(carta);
		setChanged();
		notifyObservers();
	}
	
	public boolean completoExodia() {
		return Exodia.estaCompleto(cartas);
	}
	
	public int cantidadDeCartas() {
		return this.cartas.size();
	}
	
	public Cementerio obtenerCementerio() {
		return new Cementerio();
	}

	public void quitarYAgregarAlCementerio(Carta carta) throws ExcepcionNoEsPosibleAgregarAlCementerio {
		throw new ExcepcionNoEsPosibleAgregarAlCementerio();	
	}

}
