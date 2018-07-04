package main.java.controlador;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.cartas.Carta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GeneradorDeImagenes {

    public static ImageView obtenerImagenDeCarta(Carta carta) throws IllegalArgumentException {
        return new ImageView("main/java/imagenes/cartas/"
                + carta.obtenerNombre().replace(" ","_")
                + ".jpg");
    }
}