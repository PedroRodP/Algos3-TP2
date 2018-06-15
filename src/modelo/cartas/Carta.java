package modelo.cartas;

import modelo.tablero.Tablero;

public abstract class Carta {
	private Efecto efecto;
	private Posicion posicion = new BocaAbajo();
	protected final String nombre;

	protected Carta(String unNombre) {
		this.nombre=unNombre;
		this.efecto =new NoEfecto();
	}

	public Carta( String nombre,Efecto efecto) {
		this.efecto = efecto;
		this.nombre = nombre;
	}

	public abstract void colocarBocaAbajo(Tablero tablero);
    
    public abstract void colocarBocaArriba(Tablero tablero);
    
    public void voltear() {
    	posicion = new BocaArriba();
    	this.efecto.aplicarEfecto();
    }
    
    public boolean estaBocaArriba() {
    	return posicion.estaBocaArriba();
    }

	public boolean tenesEsteNombre(String unNombreCarta){
		return (this.nombre==unNombreCarta);
	};
}
