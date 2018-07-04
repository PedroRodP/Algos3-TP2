package main.java.cartas.campo.campos;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.monstruo.Monstruo;

public class NoCampo extends Campo {
	
	public NoCampo() {
		super();
	}

	@Override
	public void desactivarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		
	}

	@Override
	public void activarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		
	}
}
