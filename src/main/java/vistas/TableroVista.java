package main.java.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import main.java.general.Jugador;

public class TableroVista {

    public TableroVista(Jugador jugador, GridPane tablero){

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        tablero.getColumnConstraints().add(col);

        RowConstraints filaMano = new RowConstraints();
        filaMano.setPercentHeight(25);
        tablero.getRowConstraints().add(filaMano);
        GridPane mano = new GridPane();
        new ManoVista(jugador.obtenerMano(),mano);
        tablero.add(mano,0,0);

        RowConstraints filaZonaMonstruos = new RowConstraints();
        filaZonaMonstruos.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMonstruos);
        GridPane zonaMonstruos = new GridPane();
        new ZonaMonstruoVista(jugador.obtenerZonaMonstruos(),zonaMonstruos);
        tablero.add(zonaMonstruos,0,1);

        RowConstraints filaZonaMagica = new RowConstraints();
        filaZonaMagica.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMagica);
        GridPane zonaMagica = new GridPane();
        new ZonaMagicaVista(jugador.obtenerZonaMagicaYTrampa(),zonaMagica);
        tablero.add(zonaMagica,0,2);

        RowConstraints filaZonaCampo = new RowConstraints();
        filaZonaCampo.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaCampo);
        GridPane zonaCampo = new GridPane();
        new ZonaCampoVista(jugador.obtenerZonaCampo(),zonaCampo);
        tablero.add(zonaCampo,0,3);

        mano.setStyle("-fx-border-color: green");
        zonaCampo.setStyle("-fx-border-color: red");
        zonaMagica.setStyle("-fx-border-color: orange");
        zonaMonstruos.setStyle("-fx-border-color: black");
    }
}
