package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import main.java.general.Jugador;

public class TableroVista {

    public TableroVista(Jugador jugador, Pane paneTablero){
        GridPane tablero = new GridPane();
        tablero.setAlignment(Pos.TOP_CENTER);
        Pane mano = new Pane();
        new ManoVista(jugador.obtenerMano(),mano);
        tablero.add(mano,0,0);

        Pane zonaMonstruos = new Pane();
        new ZonaMonstruoVista(jugador.obtenerZonaMonstruos(),zonaMonstruos);
        tablero.add(zonaMonstruos,0,1);

        Pane zonaMagica = new Pane();
        new ZonaMagicaVista(jugador.obtenerZonaMagicaYTrampa(),zonaMagica);
        tablero.add(zonaMagica,0,2);
        paneTablero.getChildren().add(tablero);

    }
}
