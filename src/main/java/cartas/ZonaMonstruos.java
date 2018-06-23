package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class ZonaMonstruos implements Lugar {

	private LinkedList<Monstruo> monstruos;
	private Cementerio cementerio;
	
	public ZonaMonstruos(Cementerio cementerio) {
		this.monstruos = new LinkedList<>();
		this.cementerio = cementerio;
	}
	
	public void agregar(Magica magica) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Trampa trampa) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Campo campo) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Monstruo carta) {
		monstruos.add(carta);
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
		monstruos.remove(monstruo);
		cementerio.agregar(monstruo);
		return cementerio;
	}
	@Override
	public Cementerio quitarYAgregarAlCementerio(Magica magica) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	@Override
	public Cementerio quitarYAgregarAlCementerio(Trampa trampa) throws ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}

	public LinkedList<Monstruo> obtenerMonstruos() {
		return monstruos;
	}
}
