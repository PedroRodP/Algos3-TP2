package main.java.vistas;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public class CartaVista {
    protected Carta carta;
    protected Pane pane;
    protected Observer observer;

    protected CartaVista(){}

    public CartaVista(Carta c, Pane pane) {
        this.carta = c;
        this.pane = pane;
        this.observer = (o, arg) -> {
            mostrarImagen();
        };
        mostrarImagen();
    }

    protected void mostrarImagen(){
        Button boton= new Button(carta.obtenerNombre());
        try {
            ImageView imagen1 = GeneradorDeImagenes.obtenerImagenDeCarta(carta);
            boton.setOnAction(event -> {
                Alerta.display(carta.obtenerNombre(),imagen1);
            });

            ImageView image = GeneradorDeImagenes.obtenerImagenDeCarta(carta);
            image.setFitHeight(100);
            image.setFitWidth(80);
            pane.getChildren().add(image);

        } catch (IllegalArgumentException e) {
            System.out.println("FALTA IMAGEN");
        }
        pane.getChildren().addAll(boton);
    }

    public void removerObservador(){
        if (observer != null) carta.deleteObserver(observer);
    }
}
