package main.java.efectos;

import java.util.LinkedList;

import main.java.cartas.Efecto;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Jugador;

public class EfectoAgujeroNegro extends Efecto {
	
	Jugador poseedor;
	Jugador oponente;
	
	public EfectoAgujeroNegro(Jugador poseedor, Jugador oponente) {
		this.poseedor = poseedor;
		this.oponente = oponente;
	}
	
	@Override
	public void aplicar() {
		LinkedList<Monstruo> monstruosPoseedor = poseedor.obtenerMonstruos();
		LinkedList<Monstruo> monstruosOponente = oponente.obtenerMonstruos();
		for (Monstruo m: monstruosPoseedor) poseedor.destruirMonstruo(m);
		for (Monstruo m: monstruosOponente) oponente.destruirMonstruo(m);
	}
	
}
