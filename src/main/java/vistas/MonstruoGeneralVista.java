package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;

public abstract class MonstruoGeneralVista extends CartaVista {

    public boolean seleccionado = false;

    public MonstruoGeneralVista(Monstruo monstruo, GridPane pane) {
        super(monstruo, pane);
    }

    public void seleccionar(){
        if (seleccionado) {
            EscenaJugador.desseleccionar(this);
            destacar(false);
        }else{
            EscenaJugador.seleccionar(this);
            destacar(true);
        }
        seleccionado = !seleccionado;
    }

    protected abstract Monstruo obtenerMonstruo();
}
