package main.java.cartas.monstruo;

import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public interface ModoDeCombate {
	
	public double potencia();
	
	public double diferenciaDeCombateCon(Monstruo monstruo) throws ExcepcionMonstruoNoPuedeAtacar;
	
	public void quitarVida(Jugador jugador, double danio);
	
	public void actualizarPotencialDeAtaque(double puntos);
	
	public void actualizarPotencialDeDefensa(double puntos);
	

}
