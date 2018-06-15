package main.java.efectos;

import java.util.LinkedList;

import main.java.cartas.Efecto;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class EfectoAgujeroNegro extends Efecto {
	
	private LinkedList<Monstruo> monstruos;
	
	public EfectoAgujeroNegro(LinkedList<Monstruo> monstruos) {
		this.monstruos = monstruos;
	}
	
	@Override
	public void aplicar() {
		for (Monstruo m: monstruos) {
			m.mandarAlCementerio();
		}
	}
	
}
