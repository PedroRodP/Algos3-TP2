package main.java.controlador;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.cartas.Carta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GeneradorDeImagenes {

    public static ImageView obtenerImagenDelanteraDeCarta(Carta carta) throws FileNotFoundException {
        try {
            return new ImageView("main/java/imagenes/cartas/"
                    + carta.obtenerNombre().replace(" ", "_")
                    + ".jpg");
        }catch (IllegalArgumentException e){
            throw new FileNotFoundException();
        }
    }

    public static ImageView obtenerImagenTraseraDeCarta(){
        return new ImageView("main/java/imagenes/cartas/Carta_dada_vuelta.jpg");
    }

    public static ImageView obtenerImagenDeCartaZonaMonstruo(){
        return new ImageView("main/java/imagenes/cartas/MonsterCardZone.jpg");
    }
}