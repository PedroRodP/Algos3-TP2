package main.java.vistas.zonas;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.vistas.cartas.CartaVista;
import main.java.vistas.cartas.MonstruoRivalVista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observer;

public class ZonaMonstruoRivalVista {
    private final int MAX_CANTIDAD_CARTAS = 5;

    private ZonaMonstruos zona;
    private Observer observer;
    private GridPane pane;
    private ArrayList<MonstruoRivalVista> vistas = new ArrayList<>();

    public ZonaMonstruoRivalVista(ZonaMonstruos zona, GridPane pane) {
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
            vistas.add(new MonstruoRivalVista(monstruos.get(i),gridPane));
            pane.add(gridPane,i,0);
        }
    }
}
