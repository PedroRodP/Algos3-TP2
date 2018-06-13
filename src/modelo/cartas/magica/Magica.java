package modelo.cartas.magica;

import modelo.cartas.Carta;
import modelo.tablero.Tablero;

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
