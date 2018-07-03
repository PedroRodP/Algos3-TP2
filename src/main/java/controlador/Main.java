package main.java.controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
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

        BorderPane contenedorPrincipal = new BorderPane();

        VBox contenedorJugadores = new VBox(100);
        llenarContenedorJugadores(alGoOh.obtenerJugadores(),contenedorJugadores);
        contenedorPrincipal.setLeft(contenedorJugadores);

        VBox contenedorTablero = new VBox(100);
        llenarContenedorTablero(alGoOh.obtenerJugadores(),contenedorTablero);

        contenedorPrincipal.setCenter(contenedorTablero);


        alGoOh.obtenerJugadores().get(1).quitarVida(500);
        alGoOh.addObserver((o, arg) -> {
            //Log.debug("AlGoOh observer");
        });


        alGoOh.siguienteTurno();
        alGoOh.obtenerJugadores().get(1).jugarCartaBocaArriba(alGoOh.obtenerJugadores().get(1).obtenerMano().obtenerCartas().getFirst());



        scene = new Scene(contenedorPrincipal, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void llenarContenedorJugadores(ArrayList<Jugador> jugadores,VBox contenedorJugadores){
        contenedorJugadores.setAlignment(Pos.CENTER);
        for (Jugador j : jugadores){
            Pane pane = new Pane();
            contenedorJugadores.getChildren().add(pane);
            new JugadorVista(j,pane);
        }
    }

    private void llenarContenedorTablero(ArrayList<Jugador> jugadores,VBox contenedorTableros){
        contenedorTableros.setAlignment(Pos.CENTER);
        for (Jugador j : jugadores){
            StackPane pane = new StackPane();
            pane.setAlignment(Pos.TOP_CENTER);
            new TableroVista(j,pane);
            contenedorTableros.getChildren().add(pane);


        }

    }
}

