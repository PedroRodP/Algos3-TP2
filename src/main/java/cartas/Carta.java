package main.java.cartas;

import java.util.LinkedList;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaNoNecesitaSacrificios;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public abstract class Carta {

	protected String nombre;
	protected Posicion posicion;
	protected Lugar lugar;

	public String nombre() {
		return nombre;
	}
	
	public void setBocaArriba() {
		this.posicion = new BocaArriba();
	}
	
	public void setBocaAbajo() {
		this.posicion = new BocaAbajo();
	}
	
	public boolean estaBocaArriba() {
		return posicion.estaBocaArriba();
	}

    public abstract void mandarAlCementerio();

	public boolean estaEnElCementerio(){
	    return lugar.esUnCementerio();
    }
	
	public void agregarseEn(ZonaMonstruos zona, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios{
		throw new ExcepcionCartaNoNecesitaSacrificios();
	}
	
	public abstract void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes;
}
