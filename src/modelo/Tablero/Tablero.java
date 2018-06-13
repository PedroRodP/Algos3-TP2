package modelo.Tablero;

import java.util.LinkedList;

import modelo.cartas.magica.Magica;
import modelo.cartas.monstruo.Monstruo;
import modelo.cartas.trampa.Trampa;

public class Tablero {

	private LinkedList<Monstruo> zonaMonstruos= new LinkedList<Monstruo>();
	private LinkedList<Magica> zonaMagicas= new LinkedList<Magica>();
	private LinkedList<Trampa> zonaTrampa = new LinkedList<Trampa>();
	
	public void agregarEnZonaDeCartasMagicas(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarEnZonaDeCartasMonstruo(Monstruo cartaMonstruo) {
		zonaMonstruos.add(cartaMonstruo);
	}

	public void agregarEnZonaDeCartasTrampa(Trampa cartaTrampa) {
		zonaTrampa.add(cartaTrampa);
	}

	public Magica obtenerCartaMagica(String unNombreMagica) {

		for (Magica unaCarta : zonaMagicas){

			if(unaCarta.tenesEsteNombre(unNombreMagica)) return unaCarta;
		}

		return null;
	}
}
