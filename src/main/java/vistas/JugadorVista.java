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
        pane.getChildren().add( new Label("VIDA DE : "+jugador.obtenerPuntosDeVida()));
        pane.getChildren().add(new Label("VIDA RIVAL: "+ jugador.obtenerOponente().obtenerPuntosDeVida()));

        observer = (o, arg) -> {
            pane.getChildren().clear();
            pane.getChildren().add(new Label("MI VIDA: "+jugador.obtenerPuntosDeVida()));
            pane.getChildren().add(new Label("VIDA RIVAL: "+ jugador.obtenerOponente().obtenerPuntosDeVida()));
        };
        jugador.addObserver(observer);
        jugador.obtenerOponente().addObserver(observer);
        this.jugador = jugador;
    }

}
