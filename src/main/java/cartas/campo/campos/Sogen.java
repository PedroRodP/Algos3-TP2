package main.java.cartas.campo.campos;

import java.util.LinkedList;

import main.java.cartas.campo.Campo;
import main.java.cartas.monstruo.Monstruo;

public class Sogen extends Campo {
	
	public Sogen() {
		super();
		nombre = "Sogen";
	}
	
	@Override
	public void activarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		for (Monstruo m: monstruosPropios) m.alterarDefensa(500);
		for (Monstruo m: monstruosRivales) m.alterarAtaque(200);
	}
	
	@Override
	public void desactivarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		for (Monstruo m: monstruosPropios) m.alterarDefensa(-500);
		for (Monstruo m: monstruosRivales) m.alterarAtaque(-200);
	}
	
}
