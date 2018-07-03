package main.java.vistas;

import main.java.general.Jugador;

import java.util.Observable;
import java.util.Observer;

public class JugadorVista {
    private Jugador jugador;
    private Observer observer;

    public JugadorVista(Jugador jugador){
        observer = (o, arg) -> {

        };
        jugador.addObserver(observer);
        this.jugador = jugador;
    }

}
