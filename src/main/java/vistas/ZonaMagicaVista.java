package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class ZonaMagicaVista {
    private Observer observer;
    private Pane pane;
    private ZonaMagicasYTrampas zona;
    public ZonaMagicaVista(ZonaMagicasYTrampas zona, GridPane pane) {
        this.zona= zona;
        this.zona=zona;
        this.pane=pane;
        llamarfuncion();
        observer= ((o, arg) -> {
            pane.getChildren().remove(0);
            llamarfuncion();
        });

        zona.addObserver(observer);
    }

    private void llamarfuncion(){
        LinkedList<Magica> magicas=zona.obtenerMagicas();
        LinkedList<Trampa> trampas=zona.obtenerTrampas();
        HBox zonaMyT= new HBox(20);
        for(Magica m: magicas){
            StackPane paneMagica = new StackPane();
            new MagicaVista(m,paneMagica);
            zonaMyT.getChildren().add(paneMagica);
        }
        for (Trampa t: trampas ){
            StackPane paneTrampa = new StackPane();
            paneTrampa.setAlignment(Pos.CENTER);
            new TrampaVista(t,paneTrampa);
            zonaMyT.getChildren().add(paneTrampa);
        }
        this.pane.getChildren().add(zonaMyT);
    }
}
