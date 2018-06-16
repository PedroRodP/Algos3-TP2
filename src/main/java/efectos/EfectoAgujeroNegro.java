package main.java.efectos;

import java.util.LinkedList;

import main.java.cartas.Efecto;
import main.java.cartas.monstruo.Monstruo;

public class EfectoAgujeroNegro extends Efecto {
	
	private LinkedList<Monstruo> monstruos;
	
	public EfectoAgujeroNegro() {}

	public void afectaA(LinkedList<Monstruo> monstruos){
		this.monstruos = monstruos;
	}
	
	@Override
	public void aplicar() {
		for (Monstruo m: monstruos) {
			m.mandarAlCementerio();
		}
	}
	
}
