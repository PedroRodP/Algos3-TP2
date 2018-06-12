package modelo.campo;

import java.util.LinkedList;

import modelo.cartas.magica.Magica;
import modelo.cartas.monstruo.Monstruo;
import modelo.cartas.trampa.Trampa;

public class Campo {

	private LinkedList<Monstruo> zonaMonstruos;
	private LinkedList<Magica> zonaMagicas;
	private LinkedList<Trampa> zonaTrampa;
	
	public void agregarEnZonaDeCartasMagicas(Magica cartaMagica) {
		zonaMagicas.add(cartaMagica);
	}
	
	public void agregarEnZonaDeCartasMonstruo(Monstruo cartaMonstruo) {
		zonaMonstruos.add(cartaMonstruo);
	}
}
