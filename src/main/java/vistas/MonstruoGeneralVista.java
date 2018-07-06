package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;

public abstract class MonstruoGeneralVista extends CartaVista {


    public MonstruoGeneralVista(Monstruo monstruo, GridPane pane) {
        super(monstruo, pane);
    }

    public abstract void seleccionar();

    protected abstract Monstruo obtenerMonstruo();
}
