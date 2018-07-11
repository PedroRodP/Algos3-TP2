package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.Cementerio;
import main.java.cartas.Lugar;
import main.java.cartas.monstruo.monstruos.Exodia;
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
	
	public void comprobarEstadoExodia(Jugador jugador, EstadoDeJuego estado) {
		Exodia.comprobarEstado(cartas, estado, jugador);
	}
	
	public Cementerio obtenerCementerio() {
		return new Cementerio();
	}

	public void quitarYAgregarAlCementerio(Carta carta) throws ExcepcionNoEsPosibleAgregarAlCementerio {
		throw new ExcepcionNoEsPosibleAgregarAlCementerio();	
	}

	public LinkedList<Carta> obtenerCartas() {
		return cartas;
	}

	public int cantidadDeCartas() {
		return cartas.size();
	}
}
