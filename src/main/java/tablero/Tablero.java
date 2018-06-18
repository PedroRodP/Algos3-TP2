package main.java.tablero;

import java.util.LinkedList;

import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;

public class Tablero {

	private LinkedList<Monstruo> zonaMonstruos= new LinkedList<Monstruo>();
	private LinkedList<Magica> zonaMagicas= new LinkedList<Magica>();
	private LinkedList<Trampa> zonaTrampas = new LinkedList<Trampa>();
	
	public void agregarCarta(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarCarta(Monstruo cartaMonstruo) {
		int i = 0;
		while (i < cartaMonstruo.sacrificiosNecesariosPorInvocacion()) {
			//todo deberiamos seleccionar un elemento random entre 0 y zonaMonstruos.size()-1 y destruirlo.
			this.destruirCarta(zonaMonstruos.getFirst()); 
			i++;     
		}
		//todo HAY QUE LANZAR EXCEPCION SI SE INTENTA INVOCAR MONSTRUO DE >5 ESTRELLAS Y NO HAY PARA SACRIFICAR
		zonaMonstruos.add(cartaMonstruo);
	}
	
	public void agregarCarta(Trampa cartaTrampa) {
		zonaTrampas.add(cartaTrampa);
	}
	
	public void destruirCarta(Magica cartaMagica) { //Excepcion si no la encuentra...
		cartaMagica.mandarAlCementerio();
		zonaMagicas.remove(cartaMagica);
		
	}
	
	public void destruirCarta(Trampa cartaTrampa) {
		cartaTrampa.mandarAlCementerio();
		zonaTrampas.remove(cartaTrampa);
		
	}
	
	public LinkedList<Monstruo> obtenerMonstruos(){
		return zonaMonstruos;
	}
	
	public void destruirCarta(Monstruo cartaMonstruo) {
		cartaMonstruo.mandarAlCementerio();
		zonaMonstruos.remove(cartaMonstruo);
		
	}
	
}
