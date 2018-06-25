package main.java.cartas.monstruo.monstruos;

import java.util.LinkedList;

import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;

public class DragonDefinitivoDeOjosAzules extends Monstruo {

    public DragonDefinitivoDeOjosAzules() {
        super(4500, 3800, 12);
        nombre = "Dragon definitivo de ojos azules";
    }

    @Override
    public void agregarseSacrificando(ZonaMonstruos zona, LinkedList<Monstruo> sacrificados) throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes {

    	int dragones = 0;
    	for (Monstruo monstruo : sacrificados) {
    		if (monstruo.nombre().equals("Dragon blanco de ojos azules")) {
    			dragones++;
    		}
    	}
    	
    	if (dragones < 3) {
    		throw new ExcepcionSacrificiosInsuficientes();	
    	}

		for (Monstruo monstruo : sacrificados) monstruo.mandarAlCementerio();
		super.agregarseEn(zona);
    }
}
