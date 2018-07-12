package main.java.vistas;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;
import main.java.controlador.Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class CartaVista {
    public static final int ALTO = 60;
    protected AccionCartaVista accionCartaVista;
    protected Carta carta;
    protected Label nombre;
    protected GridPane pane;
    protected Observer observer;
    protected ImageView imagen;

    public CartaVista(Carta carta, GridPane pane) {
        this.carta = carta;
        this.pane = pane;
        pane.setAlignment(Pos.CENTER);
        accionCartaVista = new AccionCartaVista(this);

        RowConstraints filaImagen = new RowConstraints();
        filaImagen.setPercentHeight(80);
        RowConstraints filaNombre = new RowConstraints();
        this.pane.getRowConstraints().addAll(filaImagen,filaNombre);

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        this.pane.getColumnConstraints().add(col);

        this.pane.setOnMouseClicked(event -> {
            Main.removerAcciones();
            accionCartaVista.borrarAcciones();
            actualizarAcciones();
            Main.agregarAccion(accionCartaVista);
        });
        observer = (o, arg) -> {
            mostrarImagen();
            mostrarNombre();
        };
        carta.addObserver(observer);
        mostrarImagen();
        mostrarNombre();
    }

    public void destacar(boolean bool){
        if (bool){
            nombre.setStyle("-fx-font-weight: bold;");
            nombre.setTextFill(Paint.valueOf("green"));
        }else {
            nombre.setStyle("-fx-font-weight: none");
            nombre.setTextFill(Paint.valueOf("white"));
        }
    }

    protected void mostrarImagen(){
        try {
            if (imagen != null) pane.getChildren().remove(imagen); // Quitar anterior si existe
            imagen = obtenerImagen();
            imagen.setFitHeight(ALTO);
            imagen.setPreserveRatio(true);
            GridPane.setHalignment(imagen,HPos.CENTER);
            pane.add(imagen,0,0);
        } catch (FileNotFoundException e) {}
    }

    protected ImageView obtenerImagen() throws FileNotFoundException {
        return (carta.estaBocaArriba())?
            GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta):
            GeneradorDeImagenes.obtenerImagenTraseraDeCarta();
    }

    protected String obtenerNombre(){
        return (carta.estaBocaArriba()) ? carta.obtenerNombre() : "Oculta";
    }

    protected void mostrarNombre(){
        if (nombre != null) pane.getChildren().remove(nombre); // Quitar anterior si existe
        nombre = new Label();
        nombre.setTextFill(Paint.valueOf("white"));
        GridPane.setHalignment(nombre,HPos.CENTER);
        nombre.setText(obtenerNombre());
        pane.add(nombre,0,1);
    }

    public void removerObservador(){
        if (observer != null) carta.deleteObserver(observer);
    }

    protected abstract void actualizarAcciones();
}
