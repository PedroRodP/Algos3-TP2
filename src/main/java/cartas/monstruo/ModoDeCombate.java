package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;
import main.java.general.Vida;

public abstract class ModoDeCombate {

	protected double puntaje;
	
	public double potencia() {
		return puntaje;
	}
	
	public abstract double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar;
	
	public abstract void quitarVida(Vida vida, double danio);
	
	public abstract void actualizarPotencialDeAtaque(double puntos);
	
	public abstract void actualizarPotencialDeDefensa(double puntos);
	

}
