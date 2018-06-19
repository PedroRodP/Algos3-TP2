package main.java.cartas;

import main.java.general.Jugador;
import main.java.tablero.Tablero;

public abstract class Carta {

	protected String nombre;

	public abstract void aplicarEfectoA(Jugador jugador);
	
	public abstract void colocarEn(Tablero tablero);

	public boolean tenesEsteNombre(String unNombreCarta){
		return this.nombre.equals(unNombreCarta);
	}
}
