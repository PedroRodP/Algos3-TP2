package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import main.java.cartas.Carta;
import main.java.general.Mano;

import java.util.LinkedList;

public class ManoVista {

    public ManoVista(Mano mano, Pane pane){
        LinkedList<Carta> cartas=mano.obtenerCartas();

        for(Carta c: cartas){
            StackPane paneCarta = new StackPane();
            paneCarta.setAlignment(Pos.CENTER);
            new CartaVista(c,paneCarta);
            pane.getChildren().add(paneCarta);


        }



    }
}
