package main.java.cartas.campo.campos;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.monstruo.Monstruo;

public class Wasteland extends Campo {
	
	public Wasteland() {
		super();
		nombre = "Wasteland";
	}

	@Override
	public void activarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		for (Monstruo m: monstruosPropios) m.alterarAtaque(200);
		for (Monstruo m: monstruosRivales) m.alterarDefensa(300);
	}
	
	@Override
	public void desactivarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		for (Monstruo m: monstruosPropios) m.alterarAtaque(-200);
		for (Monstruo m: monstruosRivales) m.alterarDefensa(-300);
	}
	
}
