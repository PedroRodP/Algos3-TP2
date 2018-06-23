package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionEfectoSoloAplicableEnVolteo;

public class InsectoComeHombres extends Monstruo {
	
	public InsectoComeHombres() {
		super(450,600,2);
		nombre = "Insecto come hombres";
	}
	
	public void aplicarEfecto(Monstruo monstruoADestruir){
		if (this.estaBocaArriba()){
			//TODO throw new ExcepcionEfectoSoloAplicableEnVolteo();
		}
		this.setBocaArriba();
		monstruoADestruir.mandarAlCementerio();
	}
}
