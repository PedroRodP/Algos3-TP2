package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;


public class MonstruoVista extends CartaVista  {

    public MonstruoVista(Monstruo m,GridPane pane) {
        carta = m;
        this.pane = pane;
        this.observer = (o, arg) -> {
            mostrarImagen();
        };
        mostrarImagen();
    }

}
