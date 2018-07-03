package main.java.vistas;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.java.cartas.ZonaMonstruos;
import main.java.cartas.monstruo.Monstruo;
import main.java.general.Mano;

import java.util.LinkedList;


public class ZonaMonstruoVista {

    public ZonaMonstruoVista(ZonaMonstruos zona, Pane pane) {

        LinkedList<Monstruo> monstruos=zona.obtenerMonstruos();

        for(Monstruo m: monstruos){
            StackPane paneMonstruo = new StackPane();
            new MonstruoVista(m,paneMonstruo);
            pane.getChildren().add(paneMonstruo);


        }
    }
}
