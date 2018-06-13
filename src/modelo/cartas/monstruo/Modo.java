package modelo.cartas.monstruo;

import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;

public interface Modo {

	public double valor();
	
	public double atacar(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar;
}
