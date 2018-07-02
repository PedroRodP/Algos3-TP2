package main.java.cartas;

import java.util.LinkedList;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;

public class Cementerio extends Lugar {
	
	private LinkedList<Carta> cementerio;
	
	public Cementerio() {
		cementerio = new LinkedList<>();
	}
	
	public boolean contiene(Carta carta) {
		return cementerio.contains(carta);
	}
	
	public void agregar(Carta carta) {
		cementerio.add(carta);
	}
	
	public void agregar(LinkedList<Monstruo> cartas) {
		cementerio.addAll(cartas);
	}

	@Override
	public boolean esUnCementerio() {
		return true;
	}
	
	public Cementerio obtenerCementerio() {
		return this;
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta) throws ExcepcionNoEsPosibleAgregarAlCementerio{
		throw new ExcepcionNoEsPosibleAgregarAlCementerio();	
	}

}
