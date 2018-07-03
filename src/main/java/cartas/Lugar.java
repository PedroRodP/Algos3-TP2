package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

import java.util.Observable;

public abstract class Lugar extends Observable {
	
	public void agregar(Monstruo carta) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Magica carta) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Trampa carta) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
		throw new ExcepcionZonaIncorrecta();
	}
	
	public void agregar(Campo carta) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
		throw new ExcepcionZonaIncorrecta();
	}
	
	public abstract void quitarYAgregarAlCementerio(Carta carta) throws ExcepcionNoEsPosibleAgregarAlCementerio;

	public boolean esUnCementerio(){
	    return false;
    }
	
	public abstract Cementerio obtenerCementerio();

}
