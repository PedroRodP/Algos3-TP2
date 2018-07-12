package main.java.vistas.cartas;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import main.java.cartas.trampa.Trampa;

public class TrampaVista extends CartaVista{

    public TrampaVista(Trampa trampa, GridPane pane) {
        super(trampa,pane);
    }

    @Override
    protected void actualizarAcciones() {}
}
