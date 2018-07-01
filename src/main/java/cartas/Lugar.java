package main.java.cartas;

import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public abstract class Lugar {

	public void agregar(Monstruo monstruo) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
	    throw new ExcepcionZonaIncorrecta();
    }
	public void agregar(Magica magica) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
	    throw new ExcepcionZonaIncorrecta();
    }
	public void agregar(Trampa trampa) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
	    throw new ExcepcionZonaIncorrecta();
    }
	public void agregar(Campo campo) throws ExcepcionZonaCompleta, ExcepcionZonaIncorrecta{
	    throw new ExcepcionZonaIncorrecta();
    }

	public Cementerio quitarYAgregarAlCementerio(Monstruo monstruo) throws ExcepcionZonaIncorrecta{
        throw new ExcepcionZonaIncorrecta();
    }
	public Cementerio quitarYAgregarAlCementerio(Magica magica) throws ExcepcionZonaIncorrecta{
        throw new ExcepcionZonaIncorrecta();
    }
	public Cementerio quitarYAgregarAlCementerio(Trampa trampa) throws ExcepcionZonaIncorrecta{
        throw new ExcepcionZonaIncorrecta();
    }
	public Cementerio quitarYAgregarAlCementerio(Campo campo) throws ExcepcionZonaIncorrecta{
        throw new ExcepcionZonaIncorrecta();
    }

	public boolean esUnCementerio(){
	    return false;
    }

}
