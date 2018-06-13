package modelo.cartas.monstruo;

import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;

public class Defensa implements Modo {
	
	private double valor;
	
	public Defensa(double valor) {
		
		this.valor = valor;
	}
	
	public double valor() {
		return this.valor;
	}
	
	public double atacar(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		throw new ExcepcionMonstruoNoPuedeAtacar();
	}

}
