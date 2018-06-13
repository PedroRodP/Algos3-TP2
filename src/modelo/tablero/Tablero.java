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
	
	public void agregarEnZonaDeCartasMagicas(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarEnZonaDeCartasMonstruo(Monstruo cartaMonstruo) {
		zonaMonstruos.add(cartaMonstruo);
	}

	public void agregarEnZonaDeCartasTrampa(Trampa cartaTrampa) {
		zonaTrampas.add(cartaTrampa);
	}
	
	public void mandarAlCementerio(Carta carta) {
		this.removerDeZona(carta);
		cementerio.add(carta);
	}
	
	private void removerDeZona(Carta carta) {
		
		//Busca en todas las zonas y la remueve
		for (Carta iterada : zonaMonstruos) {
			if (iterada == carta) {
				zonaMonstruos.remove(carta);
			}
		}
		
		for (Carta iterada : zonaMagicas) {
			if (iterada == carta) {
				zonaMagicas.remove(carta);
			}
		}
		
		for (Carta iterada : zonaTrampas) {
			if (iterada == carta) {
				zonaTrampas.remove(carta);
			}
		}
	}
	
	public boolean estaEnCementerio(Carta carta) {
		return cementerio.contains(carta);
	}
	
	public Monstruo obtenerMonstruo(int posicionMonstruo) {
		return zonaMonstruos.get(posicionMonstruo);
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
