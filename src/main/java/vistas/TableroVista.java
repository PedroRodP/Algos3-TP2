package main.java.vistas;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import main.java.general.Jugador;

public class TableroVista {

    public TableroVista(Jugador jugador, Pane paneTablero){

        HBox mano = new HBox(20);
        //new ManoVista(jugador.obtenerMano(),mano);
        paneTablero.getChildren().add(mano);

        HBox zonaMonstruos = new HBox(20);
        // new MonstruosVista(jugador.obtenerZonaMonstruos(),zonaMonstruos);
        paneTablero.getChildren().add(zonaMonstruos);

        HBox zonaMagica = new HBox(20);
        //new ZonaMagicaVista(jugador.obtenerZonaMagicaYTrampa(),zonaMagica);
        paneTablero.getChildren().add(zonaMagica);


    }
}
