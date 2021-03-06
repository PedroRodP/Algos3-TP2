package main.java.vistas;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import main.java.controlador.GeneradorDeImagenes;
import main.java.general.Jugador;
import main.java.vistas.zonas.*;

public class TableroJugadorActualVista{

    public TableroJugadorActualVista(Jugador jugador, GridPane tablero){
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        tablero.getColumnConstraints().add(col);

        RowConstraints filaMano = new RowConstraints();
        filaMano.setPercentHeight(25);
        tablero.getRowConstraints().add(filaMano);
        GridPane mano = new GridPane();
        new ManoVista(jugador.obtenerMano(),mano);
        tablero.add(mano,0,3);

        RowConstraints filaZonaMonstruos = new RowConstraints();
        filaZonaMonstruos.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMonstruos);
        GridPane zonaMonstruos = new GridPane();
        new ZonaMonstruoVista(jugador.obtenerZonaMonstruos(),zonaMonstruos);
        tablero.add(zonaMonstruos,0,2);

        RowConstraints filaZonaMagica = new RowConstraints();
        filaZonaMagica.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaMagica);
        GridPane zonaMagica = new GridPane();
        new ZonaMagicaPropiaVista(jugador.obtenerZonaMagicaYTrampa(),zonaMagica);
        tablero.add(zonaMagica,0,1);


        RowConstraints filaZonaCampo = new RowConstraints();
        filaZonaCampo.setPercentHeight(25);
        tablero.getRowConstraints().add(filaZonaCampo);


        BorderPane pane = new BorderPane();
        tablero.add(pane,0,0);

        GridPane zonaCampo = new GridPane();
        pane.setLeft(zonaCampo);
        new ZonaCampoVista(jugador.obtenerZonaCampo(),zonaCampo);

        StackPane mazoPane = new StackPane();
        pane.setRight(mazoPane);
        new MazoVista(jugador.obtenerMazo(),mazoPane);

        ImageView logo = GeneradorDeImagenes.obtenerLogo();
        logo.setFitHeight(70);
        logo.setPreserveRatio(true);
        pane.setCenter(logo);
    }
}
