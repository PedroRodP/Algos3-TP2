package modelo.cartas.magica;

import modelo.campo.Campo;
import modelo.cartas.Carta;

public class Magica extends Carta{
	
	public void agregarEnCampo(Campo campo) {
		campo.agregarEnZonaDeCartasMagicas(this);
	}
}
