package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import main.java.general.Jugador;

public class TableroVista {

    public TableroVista(Jugador jugador, Pane paneTablero){

        HBox mano = new HBox(20);
        mano.setAlignment(Pos.TOP_CENTER);
        new ManoVista(jugador.obtenerMano(),mano);
        paneTablero.getChildren().add(mano);

        HBox zonaMonstruos = new HBox(20);
        zonaMonstruos.setAlignment(Pos.CENTER);
        new ZonaMonstruoVista(jugador.obtenerZonaMonstruos(),zonaMonstruos);
        paneTablero.getChildren().add(zonaMonstruos);

        HBox zonaMagica = new HBox(20);
        zonaMagica.setAlignment(Pos.CENTER);
        new ZonaMagicaVista(jugador.obtenerZonaMagicaYTrampa(),zonaMagica);
        paneTablero.getChildren().add(zonaMagica);


    }
}
