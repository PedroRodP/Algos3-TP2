package main.java.vistas;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;

import java.io.FileNotFoundException;
import java.util.Observer;

public abstract class CartaVista {
    protected Carta carta;
    protected GridPane pane;
    protected Observer observer;
    protected ImageView imagen;

    public CartaVista(Carta carta, GridPane pane) {
        this.carta = carta;
        this.pane = pane;

        RowConstraints filaImagen = new RowConstraints();
        filaImagen.setPercentHeight(70);
        RowConstraints filaNombre = new RowConstraints();
        //filaNombre.setPercentHeight(10);
        this.pane.getRowConstraints().addAll(filaImagen,filaNombre);

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        this.pane.getColumnConstraints().add(col);

        mostrarImagen();
        mostrarNombre();
    }

    protected void mostrarImagen(){
        try {
            pane.getChildren().remove(imagen); // Quitar anterior si existe

            if (carta.estaBocaArriba()){
                imagen = GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta);
                imagen.setOnMouseClicked(event -> {
                    try {
                        Alerta.display(carta.obtenerNombre(), GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta));
                    } catch (FileNotFoundException e) {}
                });
            }else {
                imagen = GeneradorDeImagenes.obtenerImagenTraseraDeCarta();
            }
            imagen.setFitHeight(pane.heightProperty().doubleValue() * 0.7);
            imagen.setPreserveRatio(true);
            //imagen.setFitWidth(70);
            pane.add(imagen,0,0);
        } catch (FileNotFoundException e) {
            System.out.println("FALTA IMAGEN "+carta.obtenerNombre()); //TODO BORRAR
        }
    }

    protected void mostrarNombre(){
        String nombre = (carta.estaBocaArriba()) ? carta.obtenerNombre() : "Oculta";
        auxMostrarNombre(nombre);
    }

    protected void auxMostrarNombre(String nombre){
        Label label = new Label();
        label.setText(nombre);
        pane.add(label,0,1);
    }

    public void removerObservador(){
        if (observer != null) carta.deleteObserver(observer);
    }
}
