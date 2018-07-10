package main.java.cartas;

import java.util.LinkedList;
import java.util.Observable;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaNoNecesitaSacrificios;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public abstract class Carta extends Observable {

	protected String nombre;
	protected Posicion posicion;
	protected Lugar lugar;
	
	public Carta() {
		posicion = new BocaAbajo();
	}

	public String obtenerNombre() {
		return nombre;
	}
	
	public void setBocaArriba() {
		this.posicion = new BocaArriba();
		setChanged();
		notifyObservers();
	}
	
	public boolean estaBocaArriba() {
		return posicion.estaBocaArriba();
	}
	
	public void setLugar(Lugar lugar) {
		this.lugar = lugar; 
	}

	public void mandarAlCementerio(){
		lugar.quitarYAgregarAlCementerio(this);
		lugar = lugar.obtenerCementerio();
		setChanged();
		notifyObservers();
	}

	public boolean estaEnElCementerio(){
	    return lugar.esUnCementerio();
    }
	
	public void agregarseEn(ZonaMonstruos zona, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionCartaNoNecesitaSacrificios, ExcepcionZonaIncorrecta{
		throw new ExcepcionCartaNoNecesitaSacrificios();
	}
	
	public abstract void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta;
}
