package modelo.cartas.monstruo;

public class Defensa implements Modo {
	
	private double valor;
	
	public Defensa(double valor) {
		
		this.valor = valor;
	}
	
	public double valor() {
		return this.valor;
	}

}
