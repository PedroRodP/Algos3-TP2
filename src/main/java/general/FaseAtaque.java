package main.java.general;

import main.java.excepciones.ExcepcionJuegoNoTermino;

public class FaseAtaque implements Fase {

	@Override
	public Jugador devolverGanador() throws ExcepcionJuegoNoTermino {
		throw new ExcepcionJuegoNoTermino();
	}

	@Override
	public Fase proxima() {
		return new FaseMagica();
	}

	@Override
	public void ejecutar(Jugador jugador) {
		//TODO Definir este metodo
		//jugador.atacar(atacante, rival);
	}
	
	/* TODO public void jugarCarta(Carta carta) {
	 * throw new NoSePuedeJugarCartaEnEstaFase();
		jugadorActual.jugarCarta(Carta carta); ...  esto pasa si estamos en fase de preparacion. La idea es q cada fase tenga toooodas
		las acciones q se pueden realizar en cada fase o etapa levantando excepciones si no corresponde una accion en una fase 
		La idea es q la fase sepa el jugador actual 

	}
	
	public void pasarASigFase() {
		faseActual.siguienteFase();
	} TODO */
}
