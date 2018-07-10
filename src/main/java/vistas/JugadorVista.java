package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.java.general.Jugador;

import java.util.Observable;
import java.util.Observer;

public class JugadorVista {
    private Jugador jugador;
    private Observer observer;
    private Pane pane;

    public JugadorVista(Jugador jugador,VBox pane){
        this.pane = pane;
        this.jugador = jugador;

        observer = (o, arg) -> {
            actualizar();
        };
        actualizar();
        jugador.addObserver(observer);
    }

    private void actualizar(){
        pane.getChildren().clear();
        pane.getChildren().add(new Label("VIDA: "+jugador.obtenerPuntosDeVida()));
    }
}
