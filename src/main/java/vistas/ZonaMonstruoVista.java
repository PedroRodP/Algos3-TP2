package main.java.vistas;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Mano;
import javafx.scene.control.Label;
import java.util.Observer;

import java.util.LinkedList;


public class ZonaMonstruoVista {
    private ZonaMonstruos zona;
    private Observer observer;
    private  Pane pane;

    public ZonaMonstruoVista(ZonaMonstruos zona, Pane pane) {
        this.pane=pane;
        this.zona=zona;
        llamarFuncion();
        observer = (o, arg) -> {
            pane.getChildren().remove(0);
            llamarFuncion();
        };
            zona.addObserver(observer);

    }

    private void llamarFuncion(){
        LinkedList<Monstruo> monstruos=zona.obtenerMonstruos();
        HBox paneZona=new HBox(20);
        for(Monstruo m: monstruos){
            StackPane paneMonstruo = new StackPane();
            new MonstruoVista(m,paneMonstruo);
            paneZona.getChildren().add(paneMonstruo);
    }
    this.pane.getChildren().add(paneZona);}
}
