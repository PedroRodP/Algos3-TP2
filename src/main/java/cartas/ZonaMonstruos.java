package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.monstruo.Monstruo;

public class ZonaMonstruos extends Lugar {

	private LinkedList<Monstruo> monstruos;
	private Cementerio cementerio;
	
	public ZonaMonstruos(Cementerio cementerio) {
		this.monstruos = new LinkedList<>();
		this.cementerio = cementerio;
	}
	
	@Override
	public void agregar(Monstruo carta) {

		monstruos.add(carta);
		setChanged();
		notifyObservers();
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta){
		monstruos.remove(carta);
		cementerio.agregar(carta);
		setChanged();
		notifyObservers();
	}
	
	public Cementerio obtenerCementerio() {
		return cementerio;
	}

	public LinkedList<Monstruo> obtenerMonstruos() {
		return monstruos;
	}
}
