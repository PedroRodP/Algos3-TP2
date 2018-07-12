package main.java.vistas.contenedores;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.java.general.Jugador;
import main.java.vistas.JugadorVista;
import main.java.vistas.contenedores.ContenedorBarraVidas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ContenedorJugadores {
    private Pane pane;
    private HashMap<Jugador,JugadorVista> mapJugadores = new HashMap<>();
    private StackPane paneVida;

    public ContenedorJugadores(Pane pane, ArrayList<Jugador> jugadores, LinkedList<String> nombres){
        this.pane = pane;

        for (int i = 1; i <= jugadores.size();i++){
            Jugador j = jugadores.get(i-1);
            mapJugadores.put(j,new JugadorVista(j,nombres.get(i-1)));
        }


        this.paneVida = new StackPane();
        paneVida.setAlignment(Pos.CENTER);

        new ContenedorBarraVidas(mapJugadores,jugadores,paneVida);
    }

    public void cambiarJugador(Jugador jugador){
        pane.getChildren().clear();
        VBox panAux = new VBox(40);
        panAux.setAlignment(Pos.CENTER);
        panAux.getChildren().addAll(obtenerJugadorVista(jugador).obtenerVista(),this.paneVida);
        pane.getChildren().add(panAux);
    }

    public JugadorVista obtenerJugadorVista(Jugador jugador){
        return mapJugadores.get(jugador);
    }

}
