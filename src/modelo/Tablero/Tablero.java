package modelo.Tablero;

import java.util.LinkedList;

import modelo.cartas.Carta;
import modelo.cartas.magica.Magica;
import modelo.cartas.monstruo.Monstruo;
import modelo.cartas.trampa.Trampa;

public class Tablero {

	private LinkedList<Monstruo> zonaMonstruos= new LinkedList<Monstruo>();
	private LinkedList<Magica> zonaMagicas= new LinkedList<Magica>();
	private LinkedList<Trampa> zonaTrampa = new LinkedList<Trampa>();
	private LinkedList<Carta> cementerio = new LinkedList<Carta>();
	
	public void agregarEnZonaDeCartasMagicas(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarEnZonaDeCartasMonstruo(Monstruo cartaMonstruo) {
		zonaMonstruos.add(cartaMonstruo);
	}

	public void agregarEnZonaDeCartasTrampa(Trampa cartaTrampa) {
		zonaTrampa.add(cartaTrampa);
	}
	
	public void mandarAlCementerio(Carta carta) {
		cementerio.add(carta);
	}

	public Magica obtenerCartaMagica(String unNombreMagica) {

		for (Magica unaCarta : zonaMagicas){

			if(unaCarta.tenesEsteNombre(unNombreMagica)) return unaCarta;
		}

		return null;
	}

	public Trampa obtenerCartaTrampa(String unNombre) {
		for(Trampa unaCarta: zonaTrampa){
			if(unaCarta.tenesEsteNombre(unNombre)) return unaCarta;
		}
		return null;
	}
}
