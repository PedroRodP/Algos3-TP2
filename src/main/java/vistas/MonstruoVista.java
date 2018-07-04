package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.java.cartas.monstruo.Monstruo;


public class MonstruoVista extends CartaVista  {

    public MonstruoVista(Monstruo m,Pane pane) {
        carta = m;
        this.pane = pane;
        this.observer = (o, arg) -> {
            mostrarImagen();
        };
        mostrarImagen();
    }

}
