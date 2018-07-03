package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import main.java.cartas.Carta;

public class CartaVista {

    public CartaVista(Carta c, Pane pane) {
        //String urlImagen= m.obtenerUrl();
        //ImageView imagen = new ImageView(urlImagen);
        Button boton= new Button("jugarCarta");
        boton.setOnAction(event -> {});
        //pane.getChildren().addAll(imagen,boton);
        // falta la forma de que la carta le pase el url de su imagen
    }
}
