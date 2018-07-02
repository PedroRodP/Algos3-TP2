package main.java.cartas.campo;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;

public abstract class Campo extends Carta {
	
	protected LinkedList<Monstruo> monstruosPropios;
	protected LinkedList<Monstruo> monstruosRivales;
	
	public void afectaA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales) {
		this.monstruosPropios = monstruosPropios;
		this.monstruosRivales = monstruosRivales;
	}
	
	@Override
	public void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) {
		this.lugar = zonaCampos;
		zonaCampos.agregar(this);
	}
	
	public abstract void aplicarEfecto();
	
	public abstract void desactivarEfecto();

}
