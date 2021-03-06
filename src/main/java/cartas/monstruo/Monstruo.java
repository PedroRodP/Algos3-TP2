package main.java.cartas.monstruo;

import java.util.LinkedList;

import main.java.cartas.Carta;
import main.java.cartas.ZonaCampo;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.ZonaMonstruos;
import main.java.excepciones.*;
import main.java.general.Jugador;

public abstract class Monstruo extends Carta {

	private double ataque;
	private double defensa;
	private ModoDeCombate modo;
	private Clasificacion clasificacion;
	
	public Monstruo(double ataque, double defensa, int cantidadDeEstrellas) {
		super();
		this.ataque = ataque;
		this.defensa = defensa;
		this.colocarEnDefensa(); //Se inicializa en modo defensivo
		this.clasificacion = new Clasificacion(cantidadDeEstrellas);
	}

	public boolean estaEnDefensa(){
		return modo.estaEnDefensa();
	}

	public void colocarEnAtaque() {
		this.modo = new ModoAtaque(ataque);
		setChanged();
		notifyObservers();
	}
	
	public void colocarEnDefensa() {
		this.modo = new ModoDefensa(defensa);
		setChanged();
		notifyObservers();
	}
	
	public void aplicarEfecto(Monstruo monstruo) {
		//No todos los monstruos tienen efecto
	}
	
	protected void contraatacar(Monstruo monstruo) {
		//No todos los monstruos contraatacan
	}

	public void atacar(Monstruo monstruoRival, Jugador atacante, Jugador oponente) throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
		
		double diferenciaDeCombate = diferenciaDeCombateCon(monstruoRival);
		monstruoRival.setBocaArriba(); //El ataque voltea al monstruo atacado y lo deja boca arriba
		
		monstruoRival.contraatacar(this); 
		
		if (this.estaEnElCementerio()) return; //El contraataque del monstruo atacado puede destruir al monstruo atacante

		if (diferenciaDeCombate == 0) {
			mandarAlCementerio();
			monstruoRival.mandarAlCementerio();
			return;
		}
		if (diferenciaDeCombate < 0) {
			quitarVida(atacante, diferenciaDeCombate);
			mandarAlCementerio();
		} else {
			monstruoRival.quitarVida(oponente, diferenciaDeCombate);
			monstruoRival.mandarAlCementerio();
		}
		setChanged();
		notifyObservers();
	}
	
	private double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		if (posicion.estaBocaAbajo()) {
			throw new ExcepcionCartaBocaAbajo();
		}
		return this.modo.diferenciaDeCombateCon(monstruo);
	}
	
	public double potenciaDeCombate() {
		return modo.potencia();
	}
	
	public void quitarVida(Jugador jugador, double danio) {
		modo.quitarVida(jugador, danio);
		setChanged();
		notifyObservers();
	}

	@Override
	public void agregarseEn(ZonaMonstruos zonaMonstruos, LinkedList<Monstruo> sacrificados) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		clasificacion.invocarConSacrificios(this, sacrificados, zonaMonstruos);
		this.lugar = zonaMonstruos;
		setChanged();
		notifyObservers();
	}
	
	public void agregarseEn(ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaMonstruos zonaMonstruos, ZonaCampo zonaCampos) throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta, ExcepcionZonaIncorrecta {
		clasificacion.invocarSinSacrificios(this, zonaMonstruos);
		this.lugar = zonaMonstruos;
		setChanged();
		notifyObservers();
	}
	
	public void alterarAtaque(double puntos) {
		this.modo.actualizarPotencialDeAtaque(puntos);
		this.ataque += puntos;
		setChanged();
		notifyObservers();
	}
	
	public void alterarDefensa(double puntos) {
		this.modo.actualizarPotencialDeDefensa(puntos);
		this.defensa += puntos;
		setChanged();
		notifyObservers();
	}
	
	public double obtenerAtaque() {
		return this.ataque;
	}
}
