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

        Button boton= new Button(c.obtenerNombre());
        try {
        ImageView imagen1 = GeneradorDeImagenes.obtenerImagenDeCarta(c);
            boton.setOnAction(event -> {

            Alerta.display(c.obtenerNombre(),imagen1);

        });
        } catch (IllegalArgumentException e) {
            System.out.println("FALTA IMAGEN");
        }
        try {

            ImageView image = GeneradorDeImagenes.obtenerImagenDeCarta(c);
            image.setFitHeight(60);
            image.setFitWidth(50);
            pane.getChildren().add(image);
        } catch (IllegalArgumentException e) {
            System.out.println("FALTA IMAGEN");
        }
        pane.getChildren().addAll(boton);

    }
}
