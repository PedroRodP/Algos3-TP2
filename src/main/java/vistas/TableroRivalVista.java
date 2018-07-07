package main.java.vistas;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import main.java.general.Jugador;

public class TableroRivalVista {
    public TableroRivalVista(Jugador jugador, GridPane tablero){
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        tablero.getColumnConstraints().add(col);

        RowConstraints filaMano = new RowConstraints();
        filaMano.setPercentHeight(25);
        tablero.getRowConstraints().add(filaMano);
        GridPane mano = new GridPane();
        new ManoRivalVista(jugador.obtenerOponente().obtenerMano(),mano);
        tablero.add(mano,0,3);

        RowConstraints filaZonaMonstruos = new RowConstraints();
        filaZonaMonstruos.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMonstruos);
        GridPane zonaMonstruos = new GridPane();
        new ZonaMonstruoRivalVista(jugador.obtenerOponente().obtenerZonaMonstruos(),zonaMonstruos);
        tablero.add(zonaMonstruos,0,2);

        RowConstraints filaZonaMagica = new RowConstraints();
        filaZonaMagica.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMagica);
        GridPane zonaMagica = new GridPane();
        new ZonaMagicaVista(jugador.obtenerOponente().obtenerZonaMagicaYTrampa(),zonaMagica);
        tablero.add(zonaMagica,0,1);

        RowConstraints filaZonaCampo = new RowConstraints();
        filaZonaCampo.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaCampo);
        GridPane zonaCampo = new GridPane();
        new ZonaCampoVista(jugador.obtenerOponente().obtenerZonaCampo(),zonaCampo);
        tablero.add(zonaCampo,0,0);

        mano.setStyle("-fx-border-color: green");
        zonaCampo.setStyle("-fx-border-color: red");
        zonaMagica.setStyle("-fx-border-color: orange");
        zonaMonstruos.setStyle("-fx-border-color: black");
    }
}
