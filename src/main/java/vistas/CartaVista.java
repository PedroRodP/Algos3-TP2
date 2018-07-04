package main.java.vistas;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;

import java.io.FileNotFoundException;

public class CartaVista {

    public CartaVista(Carta c, Pane pane) {
        //String urlImagen= m.obtenerUrl();
        //ImageView imagen = new ImageView(urlImagen);
        Button boton= new Button(c.obtenerNombre());
        boton.setOnAction(event -> {});
        try {
            ImageView image = GeneradorDeImagenes.obtenerImagenDeCarta(c);
            pane.getChildren().add(image);
        } catch (FileNotFoundException e) {
            System.out.println("FALTA IMAGEN");
        }
        pane.getChildren().addAll(boton);
        // falta la forma de que la carta le pase el url de su imagen
    }
}
