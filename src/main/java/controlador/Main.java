package main.java.controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.general.AlGoOh;
import main.java.general.Jugador;
import main.java.vistas.JugadorVista;
import main.java.vistas.TableroVista;
//import org.mortbay.log.Log;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

public class Main extends Application {
    private final int ANCHO = 1400;
    private final int ALTO = 1000;


    private static AlGoOh alGoOh;
    private static Scene scene;
    private static Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Yu Gi OH");
        alGoOh = new AlGoOh();

        GridPane contenedorPrincipal = new GridPane();
        contenedorPrincipal.getRowConstraints().add(new RowConstraints(ALTO));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);

        contenedorPrincipal.getColumnConstraints().addAll(col1, col2, col3);

        GridPane contenedorJugadores = new GridPane();
        contenedorJugadores.setBackground(new Background(new BackgroundFill(Color.web("#456468"), CornerRadii.EMPTY, Insets.EMPTY)));
        llenarContenedorJugadores(alGoOh.obtenerJugadores(),contenedorJugadores);
        contenedorPrincipal.add(contenedorJugadores,0,0);

        GridPane contenedorTablero = new GridPane();
        llenarContenedorTablero(alGoOh.obtenerJugadores(),contenedorTablero);
        contenedorPrincipal.add(contenedorTablero,1,0);


        alGoOh.obtenerJugadores().get(1).quitarVida(500);
        alGoOh.addObserver((o, arg) -> {
            //Log.debug("AlGoOh observer");
        });
        scene = new Scene(contenedorPrincipal, ANCHO, ALTO);
        stage.setScene(scene);
        stage.show();



        alGoOh.siguienteTurno();
        alGoOh.obtenerJugadores().get(1).jugarCartaBocaArriba(alGoOh.obtenerJugadores().get(1).obtenerMano().obtenerCartas().getFirst());

    }

    private void llenarContenedorJugadores(ArrayList<Jugador> jugadores,GridPane contenedorJugadores){
        contenedorJugadores.setAlignment(Pos.CENTER);
        for (Jugador j : jugadores){
            Pane pane = new Pane();
            contenedorJugadores.getChildren().add(pane);
            new JugadorVista(j,pane);
        }
    }

    private void llenarContenedorTablero(ArrayList<Jugador> jugadores,GridPane contenedorTableros){
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        contenedorTableros.getColumnConstraints().add(col);
        for (int i = 0; i < jugadores.size();i++){
            RowConstraints fila = new RowConstraints();
            fila.setPercentHeight(100 / jugadores.size());
            contenedorTableros.getRowConstraints().add(fila);
            GridPane pane = new GridPane();
            contenedorTableros.add(pane,0,i);
            new TableroVista(jugadores.get(i),pane);
        }
    }
}

