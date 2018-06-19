package main.java.tablero;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import main.java.cartas.Carta;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;

public class Tablero {

	private LinkedList<Monstruo> zonaMonstruos= new LinkedList<Monstruo>();
	private LinkedList<Magica> zonaMagicas= new LinkedList<Magica>();
	private LinkedList<Trampa> zonaTrampas = new LinkedList<Trampa>();
	private LinkedList<Carta> cementerio = new LinkedList<Carta>();
	
	public void agregarCarta(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarCarta(Monstruo cartaMonstruo) {
		
		int i = 0;
		while (i < cartaMonstruo.sacrificiosNecesariosPorInvocacion()) {
			
			try {
				Monstruo sacrificado = zonaMonstruos.getFirst();
				this.destruirCarta(sacrificado); 
				i++;
			
			} catch (NoSuchElementException e) {
				//Se sacrifica la mayor cantidad posible de monstruos necesaria
				break;
			}
		}
		
		zonaMonstruos.add(cartaMonstruo);
	}
	
	public void agregarCarta(Trampa cartaTrampa) {
		zonaTrampas.add(cartaTrampa);
	}
	
	public void destruirCarta(Magica cartaMagica) { //Excepcion si no la encuentra...
		cementerio.add(cartaMagica);
		zonaMagicas.remove(cartaMagica);
		
	}
	
	public void destruirCarta(Trampa cartaTrampa) {
		cementerio.add(cartaTrampa);
		zonaTrampas.remove(cartaTrampa);
		
	}
	
	public void destruirTodosLosMonstruos() {
		cementerio.addAll(zonaMonstruos);
		zonaMonstruos.clear();
	}
	
	public LinkedList<Monstruo> obtenerMonstruos(){
		return zonaMonstruos;
	}
	
	public void destruirCarta(Monstruo cartaMonstruo) {
		cementerio.add(cartaMonstruo);
		zonaMonstruos.remove(cartaMonstruo);
		
	}

	public boolean cartaEstaEnCementerio(Carta carta) {
		return cementerio.contains(carta);
	}
	
}
