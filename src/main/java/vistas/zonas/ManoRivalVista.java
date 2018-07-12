package main.java.vistas.zonas;

import javafx.geometry.HPos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;
import main.java.general.Mano;

import java.util.LinkedList;
import java.util.Observer;

public class ManoRivalVista {

    private Mano mano;
    private GridPane pane;
    private Observer observer;

    public ManoRivalVista(Mano mano, GridPane pane) {
        this.mano = mano;
        this.pane = pane;

        RowConstraints fila = new RowConstraints();
        fila.setPercentHeight(100);
        this.pane.getRowConstraints().add(fila);

        actualizar();
        observer= (o, arg) -> {
            actualizar();
        };

        mano.addObserver(observer);
    }

    private void actualizar(){
        // Quitar las antiguas vistas del pane
        pane.getChildren().clear();

        LinkedList<Carta> nuevasCartas = mano.obtenerCartas();
        pane.getColumnConstraints().clear();
        for (int i = 0; i < nuevasCartas.size(); i++){
            // Agregar columna
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100 / nuevasCartas.size());
            this.pane.getColumnConstraints().add(col);

            ImageView imagen = GeneradorDeImagenes.obtenerImagenTraseraDeCarta();
            GridPane.setHalignment(imagen,HPos.CENTER);
            // Agregar las nuevas vistas
            pane.add(imagen,i,0);
        }
    }
}
