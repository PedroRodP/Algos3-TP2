package main.java.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import main.java.controlador.GeneradorDeImagenes;
import main.java.general.Mazo;


public class MazoVista {
    private Mazo mazo;
    private Label label;

    public MazoVista(Mazo mazo, StackPane pane){
        this.mazo = mazo;
        pane.getChildren().add(GeneradorDeImagenes.obtenerImagenTraseraDeCarta());
        label = new Label();
        label.setStyle("-fx-font-weight: bold;");
        mazo.addObserver((o, arg) -> {
            actualizar();
        });
        actualizar();
        pane.getChildren().add(label);
    }

    private void actualizar(){
        Integer cartas = mazo.obtenerCantidadCartas();
        label.setTextFill(Paint.valueOf(
                (cartas < 5)? "red" : "white"
        ));
        label.setText(cartas.toString());
    }
}
