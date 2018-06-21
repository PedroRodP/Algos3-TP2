package main.java.general;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.campo.Campo;
import main.java.cartas.campo.NoCampo;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;
import main.java.excepciones.ExcepcionZonaCompleta;

public class Tablero {

	private LinkedList<Monstruo> zonaMonstruos= new LinkedList<Monstruo>();
	private LinkedList<Magica> zonaMagicas= new LinkedList<Magica>();
	private LinkedList<Trampa> zonaTrampas = new LinkedList<Trampa>();
	private LinkedList<Carta> cementerio = new LinkedList<Carta>();
	private Campo cartaDeCampo = new NoCampo();
	
	public void agregarCarta(Campo cartaCampo) {
		cartaDeCampo.desactivarEfecto();
		cartaDeCampo = cartaCampo;
		cartaDeCampo.aplicarEfecto();
	}

	public void agregarCarta(Monstruo cartaMonstruo) throws ExcepcionZonaCompleta{
		
		if (zonaMonstruos.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
			zonaMonstruos.add(cartaMonstruo);
	}
	
	public void agregarCarta(Magica cartaMagica) throws ExcepcionZonaCompleta {
		
		if (zonaMagicas.size() + zonaTrampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarCarta(Trampa cartaTrampa) throws ExcepcionZonaCompleta {
		
		if (zonaMagicas.size() + zonaTrampas.size() == 5) {
			throw new ExcepcionZonaCompleta();
		}
		zonaTrampas.add(cartaTrampa);
	}
	
	public void destruirCarta(Magica cartaMagica) {
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
	
	public void destruirCartas(LinkedList<Monstruo> monstruos) {
		
		cementerio.addAll(monstruos);
		zonaMonstruos.removeAll(monstruos);
	}
	
	public LinkedList<Monstruo> obtenerMonstruos(){
		return zonaMonstruos;
	}

	public boolean cartaEstaEnCementerio(Carta carta) {
		return cementerio.contains(carta);
	}
}
