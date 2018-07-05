package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;

import java.io.FileNotFoundException;

public class CartaEnManoVista extends CartaVista {

    public CartaEnManoVista(Carta carta, GridPane pane) {
        super(carta,pane);

    }

    @Override
    protected void mostrarImagen() {
        try {
            pane.getChildren().remove(imagen); // Quitar anterior si existe

            imagen = GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta);
            imagen.setFitHeight(90);
            imagen.setFitWidth(70);
            imagen.setOnMouseClicked(event -> {
                try {
                    Alerta.display(carta.obtenerNombre(), GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta));
                } catch (FileNotFoundException e) {}
            });
            pane.add(imagen,0,0);
        } catch (FileNotFoundException e) {
            System.out.println("FALTA IMAGEN "+carta.obtenerNombre()); //TODO BORRAR
        }
    }

    @Override
    protected void mostrarNombre() {
        auxMostrarNombre(carta.obtenerNombre());
    }
}
