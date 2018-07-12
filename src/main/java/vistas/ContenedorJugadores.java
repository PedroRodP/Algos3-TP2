package main.java.vistas;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.java.general.Jugador;
import main.java.vistas.ContenedorBarraVidas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ContenedorJugadores {
    private Pane pane;
    private HashMap<Jugador,JugadorVista> mapJugadores = new HashMap<>();
    private Pane paneVida;

    public ContenedorJugadores(Pane pane, ArrayList<Jugador> jugadores, LinkedList<String> nombres){
        this.pane = pane;

        for (int i = 1; i <= jugadores.size();i++){
            Jugador j = jugadores.get(i-1);
            mapJugadores.put(j,new JugadorVista(j,nombres.get(i-1)));
        }


        this.paneVida = new Pane();
        new ContenedorBarraVidas(mapJugadores,jugadores,paneVida);
    }

    public void cambiarJugador(Jugador jugador){
        pane.getChildren().clear();
        VBox panAux = new VBox(10);
        panAux.getChildren().addAll(obtenerJugadorVista(jugador).obtenerVista(),this.paneVida);
        pane.getChildren().add(panAux);
    }

    public JugadorVista obtenerJugadorVista(Jugador jugador){
        return mapJugadores.get(jugador);
    }

}
