package main.java.general;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import main.java.cartas.Carta;
import main.java.cartas.Cementerio;
import main.java.cartas.FabricaDeCartas;
import main.java.cartas.Lugar;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionNoEsPosibleAgregarAlCementerio;

public class Mazo extends Lugar{

	private LinkedList<Carta> cartas;
	private final int MAX_CARTAS = 40;
	private final int MAX_MONSTRUOS = (int) (0.60 * MAX_CARTAS); //60 por ciento. 24 cartas
	private final int MAX_MAGICAS = (int) (0.25 * MAX_CARTAS); //25 por ciento. 10 cartas
	private final int MAX_TRAMPAS = (int) (0.10 * MAX_CARTAS); //10 por ciento. 4 cartas
	private final int MAX_CAMPOS = (int) (0.05 * MAX_CARTAS); //5 por ciento. 2 cartas
	
	public Mazo() {
		this.cartas = new LinkedList<>();
		this.generarCartasAleatoriamente();
		Collections.shuffle(cartas); //Mezcla el mazo
	}
	
	public Carta tomarCarta() throws ExcepcionMazoVacio {
		try {
			Carta c =  cartas.removeFirst();
			setChanged();
			notifyObservers();
			return c;
		} catch (NoSuchElementException e) {
			throw new ExcepcionMazoVacio();
		}
	}

	public int obtenerCantidadCartas(){
		return cartas.size();
	}
	
	private void generarCartasAleatoriamente() {
		
		FabricaDeCartas fabrica = new FabricaDeCartas();
		
		for (int i = 0; i < MAX_MONSTRUOS; i++) {
			cartas.add(fabrica.obtenerMonstruoAleatorio());
		
		}
		
		for (int i = 0; i < MAX_MAGICAS; i++) {
			cartas.add(fabrica.obtenerMagicaAleatoria());
		}
		
		for (int i = 0; i < MAX_TRAMPAS; i++) {
			cartas.add(fabrica.obtenerTrampaAleatoria());
		}
		
		for (int i = 0; i < MAX_CAMPOS; i++) {
			cartas.add(fabrica.obtenerCampoAleatorio());
		}
	}

	@Override
	public void quitarYAgregarAlCementerio(Carta carta) throws ExcepcionNoEsPosibleAgregarAlCementerio {
		throw new ExcepcionNoEsPosibleAgregarAlCementerio();
	}

	@Override
	public Cementerio obtenerCementerio() {
		return new Cementerio();  //Solamente para cumplir con la firma del metodo
	}
	
}
