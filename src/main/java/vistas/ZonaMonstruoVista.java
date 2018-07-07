package main.java.vistas;

import javafx.scene.layout.*;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;

import java.util.ArrayList;
import java.util.Observer;

import java.util.LinkedList;


public class ZonaMonstruoVista {

    private final int MAX_CANTIDAD_CARTAS = 5;

    private ZonaMonstruos zona;
    private Observer observer;
    private GridPane pane;
    private ArrayList<MonstruoVista> vistas = new ArrayList<>();

    public ZonaMonstruoVista(ZonaMonstruos zona, GridPane pane) {
        this.zona = zona;
        this.pane = pane;

        RowConstraints fila = new RowConstraints();
        fila.setPercentHeight(100);
        this.pane.getRowConstraints().add(fila);

        for (int c = 0; c < MAX_CANTIDAD_CARTAS; c++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100 / MAX_CANTIDAD_CARTAS);
            this.pane.getColumnConstraints().add(col);
        }

        actualizar();
        observer= (o, arg) -> {
            actualizar();
        };

        zona.addObserver(observer);
    }

    private void actualizar(){

        for (CartaVista carta : vistas) carta.removerObservador();
        // Quitar las antiguas vistas del pane
        pane.getChildren().clear();

        // Agregar las nuevas vistas
        LinkedList<Monstruo> monstruos = zona.obtenerMonstruos();
        for (int i = 0; i < monstruos.size(); i++){
            GridPane gridPane = new GridPane();
            vistas.add(new MonstruoVista(monstruos.get(i),gridPane));
            pane.add(gridPane,i,0);
        }
    }
}
