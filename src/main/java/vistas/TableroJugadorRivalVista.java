package main.java.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import main.java.general.Jugador;
import main.java.vistas.zonas.*;

public class TableroJugadorRivalVista{

    public TableroJugadorRivalVista(Jugador jugador, GridPane tablero){
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        tablero.getColumnConstraints().add(col);

        RowConstraints filaMano = new RowConstraints();
        filaMano.setPercentHeight(25);
        tablero.getRowConstraints().add(filaMano);
        GridPane mano = new GridPane();
        new ManoRivalVista(jugador.obtenerMano(),mano);
        tablero.add(mano,0,0);

        RowConstraints filaZonaMonstruos = new RowConstraints();
        filaZonaMonstruos.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMonstruos);
        GridPane zonaMonstruos = new GridPane();
        new ZonaMonstruoRivalVista(jugador.obtenerZonaMonstruos(),zonaMonstruos);
        tablero.add(zonaMonstruos,0,1);

        RowConstraints filaZonaMagica = new RowConstraints();
        filaZonaMagica.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMagica);
        GridPane zonaMagica = new GridPane();
        new ZonaMagicaRivalVista(jugador.obtenerZonaMagicaYTrampa(),zonaMagica);
        tablero.add(zonaMagica,0,2);

        RowConstraints filaZonaCampo = new RowConstraints();
        filaZonaCampo.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaCampo);

        BorderPane pane = new BorderPane();
        tablero.add(pane,0,3);

        GridPane zonaCampo = new GridPane();
        pane.setRight(zonaCampo);
        new ZonaCampoVista(jugador.obtenerZonaCampo(),zonaCampo);

        StackPane mazoPane = new StackPane();
        pane.setLeft(mazoPane);
        new MazoVista(jugador.obtenerMazo(),mazoPane);
    }
}
