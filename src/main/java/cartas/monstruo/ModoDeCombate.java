package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public abstract class ModoDeCombate {

	protected double puntaje;
	
	public double potencia() {
		return puntaje;
	}
	
	public abstract double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar;
	
	public abstract void quitarVida(Jugador jugador, double danio);
	
	public abstract void actualizarPotencialDeAtaque(double puntos);
	
	public abstract void actualizarPotencialDeDefensa(double puntos);
	

}
