package main.java.vistas;

import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public class CartaVista {
    protected Carta carta;
    protected GridPane pane;
    protected Observer observer;
    protected ImageView imagen;

    //protected CartaVista(){}

    public CartaVista(Carta carta, GridPane pane) {
        this.carta = carta;
        this.pane = pane;

        RowConstraints filaImagen = new RowConstraints();
        filaImagen.setPercentHeight(70);
        RowConstraints filaNombre = new RowConstraints();
        filaNombre.setPercentHeight(10);
        this.pane.getRowConstraints().addAll(filaImagen,filaNombre);

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        this.pane.getColumnConstraints().add(col);

        mostrarImagen();
        mostrarNombre();

        observer = (o, arg) -> {
            mostrarImagen();
        };
        this.carta.addObserver(observer);
    }

    protected void mostrarImagen(){
        try {
            pane.getChildren().remove(imagen); // Quitar anterior si existe

            imagen = GeneradorDeImagenes.obtenerImagenDeCarta(carta);
            imagen.setFitHeight(90);
            imagen.setFitWidth(70);
            imagen.setOnMouseClicked(event -> {
                Alerta.display(carta.obtenerNombre(), GeneradorDeImagenes.obtenerImagenDeCarta(carta));
            });
            pane.add(imagen,0,0);
        } catch (IllegalArgumentException e) {
            System.out.println("FALTA IMAGEN "+carta.obtenerNombre());
        }
    }

    protected void mostrarNombre(){
        Label label = new Label();
        label.setText(carta.obtenerNombre());
        pane.add(label,0,1);
    }

    public void removerObservador(){
        if (observer != null) carta.deleteObserver(observer);
    }
}
