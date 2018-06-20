package main.java.cartas.monstruo.monstruos;

import main.java.cartas.monstruo.Monstruo;
import main.java.general.Tablero;

public class DragonDefinitivoDeOjosAzules extends Monstruo {

    public DragonDefinitivoDeOjosAzules() {

        super(4500, 3800, 12);
        nombre = "Dragon definitivo de ojos azules";
    }

    @Override
    public void colocarEnTablero(Tablero tablero){

        tablero.agregarMonstruoDefinitivo(this);

    }
}
