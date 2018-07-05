package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionZonaCompleta;

public class ZonaMonstruos extends Lugar {

	private LinkedList<Monstruo> monstruos;
	private Cementerio cementerio;
	
	public ZonaMonstruos(Cementerio cementerio) {
		this.monstruos = new LinkedList<>();
		this.cementerio = cementerio;
	}
	
	@Override
	public void agregar(Monstruo carta) throws ExcepcionZonaCompleta {
		if (monstruos.size() == 5) throw new ExcepcionZonaCompleta(); 
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
