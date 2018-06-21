package main.java.cartas.monstruo.monstruos;

import java.util.LinkedList;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.general.Tablero;

public class DragonDefinitivoDeOjosAzules extends Monstruo {

    public DragonDefinitivoDeOjosAzules() {

        super(4500, 3800, 12);
        nombre = "Dragon definitivo de ojos azules";
    }

    @Override
    public void colocarEnTablero(Tablero tablero, LinkedList<Monstruo> sacrificados) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
    	    	
    	int dragones = 0;
    	for (Monstruo monstruo : sacrificados) {
    		
    		if (monstruo.nombre() == "Dragon blanco de ojos azules") {
    			dragones++;
    		}
    	}
    	
    	if (dragones < 3) {
    		throw new ExcepcionSacrificiosInsuficientes();	
    	}
    	
		tablero.destruirCartas(sacrificados);
		tablero.agregarCarta(this);
    	
    }
}
