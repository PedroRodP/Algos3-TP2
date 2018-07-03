package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import main.java.general.Jugador;

import java.util.Observable;
import java.util.Observer;

public class JugadorVista {
    private Jugador jugador;
    private Observer observer;
    private Pane pane;

    public JugadorVista(Jugador jugador,Pane pane){
        observer = (o, arg) -> {
            pane.getChildren().add(
                    new Button("VIDA "+jugador.obtenerPuntosDeVida())
            );
        };
        jugador.addObserver(observer);
        this.jugador = jugador;
    }

}
