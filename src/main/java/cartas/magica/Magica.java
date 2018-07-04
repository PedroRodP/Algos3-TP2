package main.java.cartas.magica;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Jugador;

public abstract class Magica extends Carta{
	
	public Magica() {
		super();
	}
	
	@Override
	public void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) throws ExcepcionZonaCompleta {
		this.lugar = zonaMagicasYTrampas;
		zonaMagicasYTrampas.agregar(this);
	}
	
	public void aplicarEfecto(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales,
			Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMazoVacio {
		
		if (posicion.estaBocaAbajo()) { throw new ExcepcionCartaBocaAbajo(); }
		
		aplicarA(monstruosPropios, monstruosRivales, jugador);
		this.mandarAlCementerio();
	}
	
	protected abstract void aplicarA(LinkedList<Monstruo> monstruosPropios, LinkedList<Monstruo> monstruosRivales,
			Jugador jugador) throws ExcepcionMazoVacio;

}
