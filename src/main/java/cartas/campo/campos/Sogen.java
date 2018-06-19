package main.java.cartas.campo.campos;

import main.java.cartas.campo.Campo;
import main.java.cartas.monstruo.Monstruo;

public class Sogen extends Campo {
	
	public void aplicarEfecto() {
		for (Monstruo m: monstruosPropios) m.alterarDefensa(500);
		for (Monstruo m: monstruosRivales) m.alterarAtaque(200);
	}
	
	public void desactivarEfecto() {
		for (Monstruo m: monstruosPropios) m.alterarDefensa(-500);
		for (Monstruo m: monstruosRivales) m.alterarAtaque(-200);
	}
	
}
