package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.monstruo.Monstruo;

public class ZonaMonstruos extends Lugar {

	private LinkedList<Monstruo> monstruos;
	private Cementerio cementerio;
	
	public ZonaMonstruos(Cementerio cementerio) {
		this.monstruos = new LinkedList<>();
		this.cementerio = cementerio;
	}
	
	@Override
	public void agregar(Carta carta) {
		Monstruo cartaMonstruo = (Monstruo) carta;
		monstruos.add(cartaMonstruo);
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta){
		monstruos.remove(carta);
		cementerio.agregar(carta);
	}
	
	public Cementerio obtenerCementerio() {
		return cementerio;
	}

	public LinkedList<Monstruo> obtenerMonstruos() {
		return monstruos;
	}
}
