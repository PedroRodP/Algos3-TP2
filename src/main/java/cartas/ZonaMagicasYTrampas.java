package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaMagicasYTrampas implements Lugar {

	private LinkedList<Magica> magicas;
	private LinkedList<Trampa> trampas;
	private Cementerio cementerio;
	
	public ZonaMagicasYTrampas(Cementerio cementerio) {
		this.magicas = new LinkedList<>();
		this.trampas = new LinkedList<>();
		this.cementerio = cementerio; 
	}

	public void agregar(Monstruo monstruo) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Campo campo) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Magica carta) throws ExcepcionZonaCompleta {
		if (magicas.size() + trampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		magicas.add(carta);
	}

	public void agregar(Trampa carta) throws ExcepcionZonaCompleta {
		if (magicas.size() + trampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		trampas.add(carta);
	}

	@Override
	public boolean esUnCementerio() {
		return false;
	}

	@Override
	public Cementerio quitarYAgregarAlCementerio(Campo campo) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	@Override
	public Cementerio quitarYAgregarAlCementerio(Monstruo monstruo) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	@Override
	public Cementerio quitarYAgregarAlCementerio(Magica magica) throws ExcepcionZonaIncorrecta {
		magicas.remove(magica);
		cementerio.agregar(magica);
		return cementerio;
	}
	@Override
	public Cementerio quitarYAgregarAlCementerio(Trampa trampa) throws ExcepcionZonaIncorrecta {
		trampas.remove(trampa);
		cementerio.agregar(trampa);
		return cementerio;
	}
}
