package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class ZonaMagicaVista {

    private final int CANTIDAD_CARTAS = 5;
    private ZonaMagicasYTrampas zona;
    private Observer observer;
    private GridPane pane;
    private ArrayList<CartaVista> vistas = new ArrayList<>();

    public ZonaMagicaVista(ZonaMagicasYTrampas zona, GridPane pane) {
        this.zona = zona;
        this.pane = pane;

        RowConstraints fila = new RowConstraints();
        fila.setPercentHeight(100);
        this.pane.getRowConstraints().add(fila);

        for (int c = 0; c < CANTIDAD_CARTAS ; c++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100 / CANTIDAD_CARTAS);
            this.pane.getColumnConstraints().add(col);
        }

        actualizar();
        observer= (o, arg) -> {
            actualizar();
        };

        zona.addObserver(observer);
    }
    private void actualizar(){
        // Remover antiguos observadores
        for (CartaVista carta : vistas) carta.removerObservador();

        // Quitar las antiguas vistas del pane
        pane.getChildren().clear();

        // Agregar las nuevas vistas
        LinkedList<Magica> magicas = zona.obtenerMagicas();
        for (int i = 0; i < magicas.size(); i++){
            GridPane gridPane = new GridPane();
            vistas.add(new MagicaVista(magicas.get(i),gridPane));
            pane.add(gridPane,i,0);
        }
        LinkedList<Trampa> trampas=zona.obtenerTrampas();
        for (int i = 0; i < trampas.size(); i++){
            GridPane gridPane = new GridPane();
            vistas.add(new TrampaVista(trampas.get(i),gridPane));
            pane.add(gridPane,i,0);
        }
    }
}
