package main.java.cartas.campo;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Tablero;

public abstract class Campo extends Carta {
	
	protected LinkedList<Monstruo> monstruosPropios;
	protected LinkedList<Monstruo> monstruosRivales;
	
	public void afectaA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		this.monstruosPropios = monstruosPropios;
		this.monstruosRivales = monstruosRivales;
	}

	public void colocarEnTablero(Tablero tablero) {
		tablero.agregarCarta(this);
	}
	
	public abstract void aplicarEfecto();
	
	public abstract void desactivarEfecto();
	
}
