package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaMonstruos extends Lugar {

	private LinkedList<Monstruo> monstruos;
	private Cementerio cementerio;
	
	public ZonaMonstruos(Cementerio cementerio) {
		this.monstruos = new LinkedList<>();
		this.cementerio = cementerio;
	}
	
	public void agregar(Monstruo carta) {
		monstruos.add(carta);
	}

	@Override
	public Cementerio quitarYAgregarAlCementerio(Monstruo monstruo) throws ExcepcionZonaIncorrecta {
		monstruos.remove(monstruo);
		cementerio.agregar(monstruo);
		return cementerio;
	}

	public LinkedList<Monstruo> obtenerMonstruos() {
		return monstruos;
	}
}
