package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;

public class MagicaVista extends CartaVista {
    public MagicaVista(Magica m, GridPane pane) {
        Button boton= new Button("jugarMagica");
        pane.getChildren().add(boton);
    }


}
