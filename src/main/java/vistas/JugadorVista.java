package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.java.general.Jugador;

import java.util.Observable;
import java.util.Observer;

public class JugadorVista {
    private Jugador jugador;
    private Observer observer;
    private Pane pane;

    public JugadorVista(Jugador jugador,Pane pane){
        pane.getChildren().add( new Label("VIDA "+jugador.obtenerPuntosDeVida()));

        observer = (o, arg) -> {
            pane.getChildren().clear();
            pane.getChildren().add(
                    new Label("VIDA "+jugador.obtenerPuntosDeVida())
           );
        };
        jugador.addObserver(observer);
        this.jugador = jugador;
    }

}
