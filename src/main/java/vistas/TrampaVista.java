package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import main.java.cartas.trampa.Trampa;

public class TrampaVista {

    public TrampaVista(Trampa t, Pane pane) {
        Button boton= new Button("jugarTrampa");
        pane.getChildren().add(boton);
    }
}
