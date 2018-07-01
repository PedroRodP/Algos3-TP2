package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class Cementerio extends Lugar {
	
	private LinkedList<Carta> cementerio;
	
	public Cementerio() {
		cementerio = new LinkedList<>();
	}
	
	public boolean contiene(Carta carta) {
		return cementerio.contains(carta);
	}
	
	public void agregar(Monstruo monstruo) {
		cementerio.add(monstruo);
	}
	
	public void agregar(Magica magica) {
		cementerio.add(magica);
	}
	
	public void agregar(Trampa trampa) {
		cementerio.add(trampa);
	}
	
	public void agregar(Campo campo) {
		cementerio.add(campo);
	}

	public void agregar(LinkedList<Monstruo> cartas) {
		cementerio.addAll(cartas);
	}

	@Override
	public boolean esUnCementerio() {
		return true;
	}

}
