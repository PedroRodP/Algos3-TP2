package main.java.vistas.zonas;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import main.java.cartas.ZonaCampo;
import main.java.vistas.cartas.CampoVista;

import java.util.Observable;
import java.util.Observer;

public class ZonaCampoVista {

    private Observer observer;
    private ZonaCampo zona;
    private GridPane pane;

    public ZonaCampoVista(ZonaCampo zonaCampo, GridPane pane){
        this.pane = pane;
        this.zona = zonaCampo;

        observer = (o, arg) -> {
            actualizar();
        };
        zona.addObserver(observer);
    }

    private void actualizar() {
        pane.getChildren().clear();
        GridPane carta = new GridPane();
        new CampoVista(zona.obtenerCampo(),carta);
        pane.add(carta,0,0);
    }

}
