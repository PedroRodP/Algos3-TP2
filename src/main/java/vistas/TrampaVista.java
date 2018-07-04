package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import main.java.cartas.trampa.Trampa;

public class TrampaVista extends CartaVista{

    public TrampaVista(Trampa t, GridPane pane) {
        Button boton= new Button("jugarTrampa");
        pane.getChildren().add(boton);
    }
}
