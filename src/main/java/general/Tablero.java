package main.java.general;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import main.java.cartas.Carta;
import main.java.cartas.campo.Campo;
import main.java.cartas.campo.NoCampo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;

public class Tablero {

	private LinkedList<Monstruo> zonaMonstruos= new LinkedList<Monstruo>();
	private LinkedList<Magica> zonaMagicas= new LinkedList<Magica>();
	private LinkedList<Trampa> zonaTrampas = new LinkedList<Trampa>();
	private LinkedList<Carta> cementerio = new LinkedList<Carta>();
	private Campo cartaDeCampo = new NoCampo();
	
	public void agregarCarta(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarCarta(Campo cartaCampo) {
		this.desactivarEfectoDeCampo();
		cartaDeCampo = cartaCampo;
		cartaDeCampo.aplicarEfecto();
	}
	
	public void desactivarEfectoDeCampo() {
		cartaDeCampo.desactivarEfecto();
	}
	
	//AgregarCarta() IDEAL
	/*public void agregarCarta(Monstruo monstruo, LinkedList<Monstruo> monstruos) {
		this.destruirCartas(monstruos);
		this.agregarCarta(monstruo);
	}
	
	public void agregarCarta(Monstruo monstruo) {
		zonaMonstruos.add(monstruo);
	}*/
	
	public void agregarCarta(Monstruo cartaMonstruo){
		/*todo podriamos pasar como segundo argumento una lista con los monstruos a sacrificar (el controlador la pedira al usuario
		que vaya seleccionando los monstruos a sacrificar mediante una ventana y cuando se llene la lista le deje hacer OK*/
		//todo if zonaMonstruos.size() < cantidadDeSacrifNecesarios lanzar la excepcion sacrificiosinsuficientes.
		int i = 0;
		while (i < cartaMonstruo.sacrificiosNecesariosPorInvocacion()) {
			
			try {
				Monstruo sacrificado = zonaMonstruos.getLast();
				this.destruirCarta(sacrificado); 
				i++;
			
			} catch (NoSuchElementException e) {
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
	
	public LinkedList<Monstruo> obtenerMonstruos(){
		return zonaMonstruos;
	}
	
	public void destruirCarta(Monstruo cartaMonstruo) {
		cementerio.add(cartaMonstruo);
		zonaMonstruos.remove(cartaMonstruo);
	}
	
	public void destruirCartas(LinkedList<Monstruo> monstruos) {
		
		cementerio.addAll(monstruos);
		zonaMonstruos.removeAll(monstruos);
	}

	public boolean cartaEstaEnCementerio(Carta carta) {
		return cementerio.contains(carta);
	}
}
