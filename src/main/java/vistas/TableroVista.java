package main.java.vistas;

import javafx.scene.layout.Pane;
import main.java.general.Jugador;
import org.apache.tools.ant.taskdefs.Pack;

public class TableroVista {

    public TableroVista(Jugador jugador, Pane paneTablero){

        Pane mano = new Pane();
        //new ManoVista(jugador.obtenerMano(),mano);
        paneTablero.getChildren().add(mano);

        Pane zonaMagica = new Pane();
        //new ManoVista(jugador.obtenerMano(),mano);
        paneTablero.getChildren().add(mano);

    }
}
