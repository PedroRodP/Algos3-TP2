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

    protected CartaVista(){}

    public CartaVista(Carta c, GridPane pane) {
        this.carta = c;
        this.pane = pane;

        RowConstraints filaImagen = new RowConstraints();
        filaImagen.setPercentHeight(70);
        RowConstraints filaNombre = new RowConstraints();
        filaNombre.setPercentHeight(10);
        this.pane.getRowConstraints().addAll(filaImagen,filaNombre);

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        this.pane.getColumnConstraints().add(col);

        this.observer = (o, arg) -> {
            //mostrarImagen();
        };
        mostrarImagen();
        mostrarNombre();
    }

    protected void mostrarImagen(){
        try {
            /*ImageView imagen1 = GeneradorDeImagenes.obtenerImagenDeCarta(carta);
            boton.setOnAction(event -> {
                Alerta.display(carta.obtenerNombre(),imagen1);
            });*/
            //TODO QUITAR IMAGEN ANTERIOR SI EXISTE
            ImageView image = GeneradorDeImagenes.obtenerImagenDeCarta(carta);
            image.setFitHeight(90);
            image.setFitWidth(70);
            pane.add(image,0,0);
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
