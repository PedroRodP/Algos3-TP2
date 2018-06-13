package modelo.cartas.monstruo;

public class Ataque implements Modo {
	
	private double valor;
	
	public Ataque(double valor) {
		
		this.valor = valor;
	}
	
	public double valor() {
		return this.valor;
	}
	
	public double atacar(Monstruo monstruo) {
		return this.valor - monstruo.vida();
	}

}
