package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.Cementerio;
import main.java.cartas.Lugar;
import main.java.cartas.campo.Campo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.exodia.Exodia;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaIncorrecta;

public class Mano extends Lugar {

	private LinkedList<Carta> cartas;
	
	public Mano() {
		this.cartas = new LinkedList<>();
	}

	public void agregar(Carta carta) {
		this.cartas.add(carta);
	}
	
	public void remover(Carta carta){
        this.cartas.remove(carta);
	}
	
	public boolean completoExodia() {
		return Exodia.estaCompleto(cartas);
	}
	
	public int cantidadDeCartas() {
		return this.cartas.size();
	}

}
