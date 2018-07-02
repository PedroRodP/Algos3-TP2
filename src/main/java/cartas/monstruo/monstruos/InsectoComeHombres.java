package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;

public class InsectoComeHombres extends Monstruo {
	
	public InsectoComeHombres() {
		super(450,600,2);
		nombre = "Insecto come hombres";
	}
	
	@Override
	public void aplicarEfecto(Monstruo monstruoADestruir) {
		if (posicion.estaBocaAbajo()){
			this.setBocaArriba();
			monstruoADestruir.mandarAlCementerio();
		}
		
	}
	
	@Override
	protected void contraatacar(Monstruo monstruo) {
		aplicarEfecto(monstruo);
	}
	
}
