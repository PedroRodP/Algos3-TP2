package main.java.vistas;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Mano;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Observer;

import java.util.LinkedList;


public class ZonaMonstruoVista {
    private ZonaMonstruos zona;
    private Observer observer;
    private Pane pane;
    private ArrayList<MonstruoVista> vistas = new ArrayList<>();

    public ZonaMonstruoVista(ZonaMonstruos zona, Pane pane) {
        this.pane = pane;
        this.zona = zona;
        pane.setBackground(new Background(new BackgroundFill(Color.web("#818181"), CornerRadii.EMPTY, Insets.EMPTY)));
        llamarFuncion();
        observer = (o, arg) -> {
            this.pane.getChildren().remove(0); // Remueve HBox
            llamarFuncion();
        };
        zona.addObserver(observer);
    }

    private void llamarFuncion(){
        for (MonstruoVista vista : vistas)  vista.removerObservador();

        LinkedList<Monstruo> monstruos = zona.obtenerMonstruos();
        HBox paneZona = new HBox(20);
        for( Monstruo m: monstruos){
            StackPane paneMonstruo = new StackPane();
            vistas.add(new MonstruoVista(m,paneMonstruo));
            paneZona.getChildren().add(paneMonstruo);
        }
        this.pane.getChildren().add(paneZona);
    }
}
