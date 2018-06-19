package main.java.cartas.monstruo;

import main.java.cartas.Carta;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;
import main.java.tablero.Tablero;

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

	public void colocarEn(Tablero tablero) {
		tablero.agregarCarta(this);
	}
	
	public double potenciaDeCombate() {
		
		return modo.potencia();
	}
	
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		return this.modo.diferenciaDeCombateCon(monstruo); 
	}
	
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		this.modo.infligirDanioAJugador(jugador, danio);
	}
}
