package main.java.vistas.zonas;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;
import main.java.vistas.cartas.CartaVista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public abstract class ZonaMagicaVista {

    private final int CANTIDAD_CARTAS = 5;
    private ZonaMagicasYTrampas zona;
    private Observer observer;
    private GridPane pane;
    private ArrayList<CartaVista> vistas = new ArrayList<>();

    protected ZonaMagicaVista(ZonaMagicasYTrampas zona, GridPane pane) {
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
            vistas.add(obtenerCartaVistaMagica(magicas.get(i),gridPane));
            pane.add(gridPane,i,0);
        }
        LinkedList<Trampa> trampas=zona.obtenerTrampas();
        for (int i = magicas.size(); i < trampas.size()+magicas.size(); i++){
            GridPane gridPane = new GridPane();
            vistas.add(obtenerCartaVistaTrampa(trampas.get(i-magicas.size()),gridPane));
            pane.add(gridPane,i,0);
        }
    }

    protected abstract CartaVista obtenerCartaVistaMagica(Magica magica, GridPane gridPane);

    protected abstract CartaVista obtenerCartaVistaTrampa(Trampa trampa, GridPane gridPane);
}
