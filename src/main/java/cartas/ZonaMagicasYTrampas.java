package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.trampas.NoTrampa;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaCompleta;

public class ZonaMagicasYTrampas extends Lugar {

	private LinkedList<Magica> magicas;
	private LinkedList<Trampa> trampas;
	private Cementerio cementerio;
	
	public ZonaMagicasYTrampas(Cementerio cementerio) {
		this.magicas = new LinkedList<>();
		this.trampas = new LinkedList<>();
		this.cementerio = cementerio;
	}
	
	@Override
	public void agregar(Magica cartaMagica) throws ExcepcionZonaCompleta {
		if (magicas.size() + trampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		magicas.add(cartaMagica);
		setChanged();
		notifyObservers();
	}
	
	public void agregar(Trampa cartaTrampa) throws ExcepcionZonaCompleta{
		if (magicas.size() + trampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		trampas.add(cartaTrampa);
		setChanged();
		notifyObservers();
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta){
		trampas.remove(carta);
		magicas.remove(carta);
		cementerio.agregar(carta);
		setChanged();
		notifyObservers();
	}
	
	public Cementerio obtenerCementerio() {
		return cementerio;
	}

	public Trampa obtenerPrimeraCartaTrampa() {
		if(trampas.isEmpty()) {
			return new NoTrampa();
		}
		return trampas.getFirst();
	}

	public LinkedList<Magica> obtenerMagicas() {
		return magicas;
	}

	public LinkedList<Trampa> obtenerTrampas() {
		return trampas;
	}
}
