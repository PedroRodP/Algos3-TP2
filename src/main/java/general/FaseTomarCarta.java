package main.java.general;

public class FaseTomarCarta extends Fase {
	
	@Override
	public Fase proxima() {
		return new FasePreparacion();
	}
	
	@Override
	public void tomarCarta(Jugador jugador) {
		jugador.tomarCartaDelMazo();
	}
}
