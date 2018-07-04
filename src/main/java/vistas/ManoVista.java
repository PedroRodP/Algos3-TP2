package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import main.java.cartas.Carta;
import main.java.general.Mano;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class ManoVista {
    private final int CANTIDAD_CARTAS = 5;

    private GridPane pane;
    private Mano mano;
    private Observer observer;
    private ArrayList<CartaVista> cartas = new ArrayList<>();

    public ManoVista(Mano mano, GridPane pane){
        this.mano= mano;
        this.pane= pane;


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
        for (CartaVista carta : cartas)  carta.removerObservador();

        try {
            pane.getColumnConstraints().remove(0,CANTIDAD_CARTAS);
        }catch (IndexOutOfBoundsException e){}

        for (int c = 0; c < CANTIDAD_CARTAS ; c++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100 / CANTIDAD_CARTAS);
            this.pane.getColumnConstraints().add(col);
        }

        LinkedList<Carta> nuevasCartas = mano.obtenerCartas();
        for (int i = 0; i < nuevasCartas.size(); i++){
            GridPane gridPane = new GridPane();
            new CartaVista(nuevasCartas.get(i),gridPane);
            pane.add(gridPane,i,0);
        }
    }
}
