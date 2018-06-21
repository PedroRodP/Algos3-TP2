package main.java.cartas.campo.campos;

import main.java.cartas.campo.Campo;
import main.java.cartas.monstruo.Monstruo;

public class Wasteland extends Campo {
	
	public Wasteland() {
		nombre = "Wasteland";
	}

	public void aplicarEfecto() {
		for (Monstruo m: monstruosPropios) m.alterarAtaque(200);
		for (Monstruo m: monstruosRivales) m.alterarDefensa(300);
	}
	
	public void desactivarEfecto() {
		for (Monstruo m: monstruosPropios) m.alterarAtaque(-200);
		for (Monstruo m: monstruosRivales) m.alterarDefensa(-300);
	}
	
}
