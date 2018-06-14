package modelo.tablero;

import java.util.LinkedList;

import modelo.cartas.Carta;
import modelo.cartas.magica.Magica;
import modelo.cartas.monstruo.Monstruo;
import modelo.cartas.trampa.Trampa;

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
			this.destruirCarta(zonaMonstruos.getFirst()); //En realidad el jugador deber�a elegir que cartas sacrificar!!
			i++;                                          //Se podria usar un Iterator ... (Preguntar como hacer q el jugador elija)     
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
	
	public void destruirCarta(Monstruo cartaMonstruo) {
		cementerio.add(cartaMonstruo);
		zonaMonstruos.remove(cartaMonstruo);
		
	}
	
	public boolean estaEnCementerio(Carta carta) {
		return cementerio.contains(carta);
	}
	
	//Habria q lanzar una excepcion si la carta no es encontrada!!
	public Magica obtenerCartaMagica(String nombre) {
		for (Magica carta : zonaMagicas) {
			if(carta.tenesEsteNombre(nombre)) return carta;
		}
		return null;
	}

	public Trampa obtenerCartaTrampa(String unNombre) {
		for(Trampa unaCarta: zonaTrampas){
			if(unaCarta.tenesEsteNombre(unNombre)) return unaCarta;
		}
		return null;
	}
}
