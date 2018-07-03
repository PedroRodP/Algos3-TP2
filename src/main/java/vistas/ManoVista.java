package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import main.java.cartas.Carta;
import main.java.general.Mano;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class ManoVista {

    private Pane pane;
    private Mano mano;
    private Observer observer;

    public ManoVista(Mano mano, Pane pane){

        this.mano= mano;
        this.pane= pane;
        llamarFuncion();
        observer= (o, arg) -> {
            pane.getChildren().remove(0);
            llamarFuncion();
        };

        mano.addObserver(observer);

    }

    private void llamarFuncion(){
        LinkedList<Carta> cartas=mano.obtenerCartas();
        HBox paneMano=new HBox(20);
        for(Carta c: cartas){
            Pane paneCarta = new Pane();
            new CartaVista(c,paneCarta);
            paneMano.getChildren().add(paneCarta);


        }
        this.pane.getChildren().add(paneMano);
    }
}
