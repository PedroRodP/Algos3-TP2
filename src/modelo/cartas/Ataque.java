package modelo.cartas;

public class Ataque implements Posicion {
	
	private double valor;
	
	public Ataque(double valor) {
		
		this.valor = valor;
	}
	
	public double valor() {
		return this.valor;
	}

}
