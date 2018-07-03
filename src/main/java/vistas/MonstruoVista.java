package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.java.cartas.monstruo.Monstruo;


public class MonstruoVista  {
    public MonstruoVista(Monstruo m,Pane pane) {
        //String urlImagen= m.obtenerUrl();
        //ImageView imagen = new ImageView(urlImagen);
        Button boton= new Button("atacar");
        pane.getChildren().add(boton);
    }


}
