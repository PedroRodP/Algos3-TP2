package modelo.cartas;

import modelo.tablero.Tablero;

public abstract class Carta {
	
	protected final String nombre;

	protected Carta(String unNombre) {
		this.nombre=unNombre;
	}



    public abstract void agregarEn(Tablero unTablero);

	public boolean tenesEsteNombre(String unNombreCarta){
		return (this.nombre==unNombreCarta);
	};
}
