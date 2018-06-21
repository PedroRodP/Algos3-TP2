package main.java.cartas.monstruo.monstruos;

import java.util.Iterator;
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
    public void colocarEnTablero(Tablero tablero) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {
    	
    	LinkedList<Monstruo> zonaMonstruos = tablero.obtenerMonstruos();
    	Iterator<Monstruo> monstruos = zonaMonstruos.iterator();
    	int dragones = 0;
    	LinkedList<Monstruo> sacrificados = new LinkedList<Monstruo>();
    			
    	while (monstruos.hasNext() && dragones < 3) {
    		
    		Monstruo monstruo = monstruos.next();
    		if (monstruo.nombre() == "Dragon blanco de ojos azules") {
    			sacrificados.add(monstruo);
    			dragones++;
    		}
    	}
    	
    	if (sacrificados.size() < 3) {
    		throw new ExcepcionSacrificiosInsuficientes();	
    	}
    	
		tablero.destruirCartas(sacrificados);
		tablero.agregarCarta(this);
    	
    }
}
