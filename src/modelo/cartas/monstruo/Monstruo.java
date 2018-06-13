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
	
	public double vida() {
		
		return modo.valor();
	}
	
	public double atacar(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar {
		return this.modo.atacar(monstruo); 
	}

	@Override
	public void agregarEn(Tablero unTablero) {
		unTablero.agregarEnZonaDeCartasMonstruo(this);
	}
	
	public void infligirDanioAJugador(Jugador jugador, double danio) {
		this.modo.infligirDanioAJugador(jugador, danio);
	}
}
