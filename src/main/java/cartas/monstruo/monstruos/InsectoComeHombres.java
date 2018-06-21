package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionEfectoSoloAplicableEnVolteo;
import main.java.general.Jugador;

public class InsectoComeHombres extends Monstruo {

	Jugador jugadorAfectado;
	Monstruo monstruoADestruir;
	
	public InsectoComeHombres() {
		super(450,600,2);
		nombre = "Insecto come hombres";
	}
	
	public void afectaA(Jugador jugadorAfectado, Monstruo monstruoADestruir) {
		this.jugadorAfectado = jugadorAfectado;
		this.monstruoADestruir = monstruoADestruir;
	}
	
	public void aplicarEfecto(){
		if (this.estaBocaArriba()){
			//TODO throw new ExcepcionEfectoSoloAplicableEnVolteo();
		}
		this.setBocaArriba();
		jugadorAfectado.destruirMonstruo(monstruoADestruir);
	}
}
