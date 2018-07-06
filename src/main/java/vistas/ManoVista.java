package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.*;

import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;
import main.java.general.Mano;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observer;

public class ManoVista {

    private GridPane pane;
    private Mano mano;
    private Observer observer;


    public ManoVista(Mano mano, GridPane pane){
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

            // Agregar las nuevas vistas

            pane.add(GeneradorDeImagenes.obtenerImagenTraseraDeCarta(),i,0);
        }
    }
}
