package main.java.vistas;

import javafx.scene.layout.Pane;
import main.java.general.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class ContenedorJugadores {
    private Pane pane;
    private HashMap<Jugador,JugadorVista> mapJugadores = new HashMap<>();

    public ContenedorJugadores(Pane pane, ArrayList<Jugador> jugadores){
        this.pane = pane;

        for (int i = 1; i <= jugadores.size();i++){
            Jugador j = jugadores.get(i-1);
            mapJugadores.put(j,new JugadorVista(j,"Jugador "+i));
        }
    }

    public void cambiarJugador(Jugador jugador){
        pane.getChildren().clear();
        pane.getChildren().add(
                obtenerJugadorVista(jugador).obtenerVista()
        );
    }

    public JugadorVista obtenerJugadorVista(Jugador jugador){
        return mapJugadores.get(jugador);
    }

}
