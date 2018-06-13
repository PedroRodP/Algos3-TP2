package modelo.cartas.magica;

import modelo.Tablero.Tablero;
import modelo.cartas.Carta;

public class Magica extends Carta{



	public Magica(String unNombre) {
		super(unNombre);
	}

	public void agregarEnCampo(Tablero tablero) {
		tablero.agregarEnZonaDeCartasMagicas(this);
	}

	@Override
	public void agregarEn(Tablero unTablero) {
		unTablero.agregarEnZonaDeCartasMagicas(this);
	}

}
