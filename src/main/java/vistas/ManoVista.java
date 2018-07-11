package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import main.java.cartas.Carta;
import main.java.general.Mano;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observer;

public class ManoVista {

    private GridPane pane;
    private Mano mano;
    private Observer observer;
    private ArrayList<CartaVista> cartas = new ArrayList<>();

    public ManoVista(Mano mano, StackPane pane){
        Label nombreZona = new Label("M a n o");
        nombreZona.setFont(new Font(50));
        nombreZona.setTextFill(Paint.valueOf(
                "grey"
        ));
        pane.getChildren().add(nombreZona);
        this.mano = mano;
        this.pane = new GridPane();
        pane.getChildren().add(this.pane);

        RowConstraints fila = new RowConstraints();
        fila.setPercentHeight(100);
        //this.pane.getRowConstraints().add(fila);

        actualizar();
        observer= (o, arg) -> {
            actualizar();
        };

        mano.addObserver(observer);
    }

    private void actualizar(){
        // Remover antiguos observadores
        for (CartaVista carta : cartas) carta.removerObservador();

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
            GridPane gridPane = new GridPane();
            cartas.add(new CartaEnManoVista(nuevasCartas.get(i),gridPane));
            pane.add(gridPane,i,0);
        }
    }
}
