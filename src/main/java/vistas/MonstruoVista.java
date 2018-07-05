package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;


public class MonstruoVista extends CartaVista  {

    public MonstruoVista(Monstruo monstruo,GridPane pane) {
        super(monstruo,pane);

        observer = (o, arg) -> {

        };
        //monstruo.addObserver(observer);
    }

}
