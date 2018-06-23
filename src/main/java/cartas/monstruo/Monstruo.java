package main.java.cartas.monstruo;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaMonstruos;
import main.java.excepciones.*;
import main.java.general.Vida;

public abstract class Monstruo extends Carta {

	private double ataque;
	private double defensa;
	private ModoDeCombate modo;
	private Clasificacion clasificacion;
	
	public Monstruo(double ataque, double defensa, int cantidadDeEstrellas) {
		this.ataque = ataque;
		this.defensa = defensa;
		this.colocarEnDefensa(); //Se inicializa en modo defensivo
		this.clasificacion = new Clasificacion(cantidadDeEstrellas);
	}
	
	public void colocarEnAtaque() {
		
		this.modo = new ModoAtaque(ataque);
	}
	
	public int sacrificiosNecesariosPorInvocacion() {
		return clasificacion.cantidadDeSacrificiosPorInvocacion();
	}
	
	public void colocarEnDefensa() {
		
		this.modo = new ModoDefensa(defensa);
	}

	public void atacar(Monstruo rival, Vida vidaPropia, Vida vidaOponente) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
		double diferenciaDeCombate = diferenciaDeCombateCon(rival);

		if (diferenciaDeCombate == 0) {
			mandarAlCementerio();
			rival.mandarAlCementerio();
			return;
		}
		if (diferenciaDeCombate < 0) {
			quitarVida(vidaPropia, diferenciaDeCombate);
			mandarAlCementerio();
		} else {
			rival.quitarVida(vidaOponente, diferenciaDeCombate);
			rival.mandarAlCementerio();
		}
	}
	
	public void quitarVida(Vida vida, double danio) {
		modo.quitarVida(vida, danio);
	}

	public void agregarseSacrificando(ZonaMonstruos zona, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		if (sacrificados.size() < sacrificiosNecesariosPorInvocacion()) {
			throw new ExcepcionSacrificiosInsuficientes();
		}

		for (Monstruo m : sacrificados) m.mandarAlCementerio();
		this.agregarseEn(zona);
	}
	
	public void agregarseEn(ZonaMonstruos zona) {
		this.lugar = zona;
		zona.agregar(this);
	}
	
	public double potenciaDeCombate() {
		
		return modo.potencia();
	}
	
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		if (posicion.estaBocaAbajo()) {
			throw new ExcepcionCartaBocaAbajo();
		}
		return this.modo.diferenciaDeCombateCon(monstruo);
	}

	/*public void aplicarEfecto() throws ExcepcionCartaBocaAbajo {
		
		if (posicion.estaBocaAbajo()) {
			throw new ExcepcionCartaBocaAbajo();
		}
		//Por default los monstruos no tienen efecto
	}*/
	
	public void alterarAtaque(double puntos) {
		this.modo.actualizarPotencialDeAtaque(puntos);
		this.ataque += puntos;
	}
	
	public void alterarDefensa(double puntos) {
		this.modo.actualizarPotencialDeDefensa(puntos);
		this.defensa += puntos;
	}
	
	public double obtenerAtaque() {
		return this.ataque;
	}

	public void mandarAlCementerio(){
		try {
			lugar = lugar.quitarYAgregarAlCementerio(this);
		} catch (ExcepcionZonaIncorrecta excepcionZonaIncorrecta) {
			excepcionZonaIncorrecta.printStackTrace();
		}
	}

}
