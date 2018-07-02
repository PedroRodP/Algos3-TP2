package main.java.cartas.trampa;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.campo.Campo;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Jugador;

public abstract class Trampa extends Carta{
	
	@Override
	public void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) throws ExcepcionZonaCompleta {
		this.lugar = zonaMagicasYTrampas;
		zonaMagicasYTrampas.agregar(this);
	}

	public void aplicarA(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador oponente = jugador.obtenerOponente();
    	
    	activarCampo(jugador);
    	activarCampo(oponente);
    	
    	aplicarTrampa(atacante, defensor, jugador);
    	
    	desactivarCampo(jugador);
    	desactivarCampo(oponente);
    	
    	this.mandarAlCementerio();
		
	}
	
	protected void activarCampo(Jugador jugador) {
		
		Campo campo = jugador.obtenerCampo();
		LinkedList<Monstruo> monstruosPropios = jugador.obtenerMonstruos();
		LinkedList<Monstruo> monstruosRivales = jugador.obtenerOponente().obtenerMonstruos();
		
		campo.activarEfecto(monstruosPropios, monstruosRivales);
	}
	
	protected void desactivarCampo(Jugador jugador) {
		
		Campo campo = jugador.obtenerCampo();
		LinkedList<Monstruo> monstruosPropios = jugador.obtenerMonstruos();
		LinkedList<Monstruo> monstruosRivales = jugador.obtenerOponente().obtenerMonstruos();
		
		campo.desactivarEfecto(monstruosPropios, monstruosRivales);
	}
	
	protected void aplicarTrampa(Monstruo atacante, Monstruo defensor, Jugador jugador) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {

		atacante.atacar(defensor, jugador, jugador.obtenerOponente());
	}
}
