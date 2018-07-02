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
	public void agregar(Carta carta) throws ExcepcionZonaCompleta {
		if (magicas.size() + trampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		if (carta instanceof Magica) {
			Magica cartaMagica = (Magica) carta;
			magicas.add(cartaMagica);
		}
		
		if (carta instanceof Trampa) {
			Trampa cartaTrampa = (Trampa) carta;
			trampas.add(cartaTrampa);
		}
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta){
		trampas.remove(carta);
		magicas.remove(carta);
		cementerio.agregar(carta);
	}
	
	public Cementerio obtenerCementerio() {
		return cementerio;
	}

	public Trampa obtenerPrimeraCartaTrampa() {
		if(trampas.isEmpty()) return new NoTrampa();
		return trampas.getFirst();
	}
}
