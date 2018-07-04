package main.java.cartas.campo;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;

public abstract class Campo extends Carta {
	
	public Campo() {
		super();
	}
	
	@Override
	public void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) {
		this.lugar = zonaCampos;
		zonaCampos.agregar(this);
	}
	
	public abstract void activarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales);
	
	public abstract void desactivarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales);

}
