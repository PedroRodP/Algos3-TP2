package main.java.vistas.contenedores;

import javafx.scene.layout.*;
import main.java.general.Jugador;
import main.java.vistas.TableroJugadorActualVista;
import main.java.vistas.TableroJugadorRivalVista;

import java.util.ArrayList;
import java.util.HashMap;

public class ContenedorTableros {
    private HashMap<Jugador,Pane> contenedores = new HashMap<>();
    private GridPane gridPane;

    public ContenedorTableros(ArrayList<Jugador> jugadores, GridPane contenedor){
        gridPane = contenedor;

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        gridPane.getColumnConstraints().add(col);

        RowConstraints fila = new RowConstraints();
        fila.setPercentHeight(100);
        gridPane.getRowConstraints().add(fila);

        for (Jugador j : jugadores) inicializarTablero(j);
    }

    public void cambiarTablero(Jugador jugador){
        gridPane.getChildren().clear();
        gridPane.add(contenedores.get(jugador),0,0);
    }

    private void inicializarTablero(Jugador jugador){
        GridPane tableroPane = new GridPane();
        contenedores.put(jugador,tableroPane);

        // Crear constraints de filas y columnas
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        tableroPane.getColumnConstraints().add(col);
        RowConstraints fila = new RowConstraints();
        fila.setPercentHeight(50);
        tableroPane.getRowConstraints().add(fila);
        RowConstraints fila1 = new RowConstraints();
        fila1.setPercentHeight(50);
        tableroPane.getRowConstraints().add(fila1);

        // Agrego el tablero del jugador y su oponente.
        GridPane pane = new GridPane();
        tableroPane.add(pane,0,1);
        new TableroJugadorActualVista(jugador,pane);
        pane = new GridPane();
        tableroPane.add(pane,0,0);
        new TableroJugadorRivalVista(jugador.obtenerOponente(),pane);
    }
}



