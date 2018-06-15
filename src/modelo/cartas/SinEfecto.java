package modelo.cartas;

import modelo.general.Jugador;

public class SinEfecto implements Efecto {
	
    @Override
    public void aplicar(Jugador atacante, Jugador oponente){
    	//No debe aplicar ningun efecto
    }
}
