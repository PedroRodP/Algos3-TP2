package modelo.cartas.monstruo;

import modelo.cartas.Carta;
import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.general.Jugador;
import modelo.tablero.Tablero;

public class Monstruo extends Carta {

	private double ataque;
	private double defensa;
	private Modo modo;
	
	public Monstruo(double ataque, double defensa,String unNombre) {
		super(unNombre);

		this.ataque = ataque;
		this.defensa = defensa;
		this.colocarEnDefensa(); //Por default queda en modo defensa
	}
	
	public void colocarEnAtaque() {
		
		this.modo = new Ataque(ataque);
	}
	
	public void colocarEnDefensa() {
		
		this.modo = new Defensa(defensa);
	}
	
	public void colocarBocaArriba(Tablero tablero) {
		this.voltear();
		tablero.agregarCarta(this);
	}
	
	public void colocarBocaAbajo(Tablero tablero) {
		tablero.agregarCarta(this);
	}
	
	public double vida() {
		
		return modo.valor();
	}
	
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		return this.modo.diferenciaDeCombateCon(monstruo); 
	}
	
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		this.modo.infligirDanioAJugador(jugador, danio);
	}
}
