package main.java.controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.general.AlGoOh;
import main.java.general.Jugador;
import main.java.vistas.JugadorVista;
import main.java.vistas.TableroVista;
import org.mortbay.log.Log;

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
        primaryStage.setTitle("AlGoOh");
        alGoOh = new AlGoOh();

        BorderPane contenedorPrincipal = new BorderPane();

        VBox contenedorJugadores = new VBox(100);
        llenarContenedorJugadores(alGoOh.obtenerJugadores(),contenedorJugadores);
        contenedorPrincipal.setLeft(contenedorJugadores);

        VBox contenedorTablero = new VBox(100);

        contenedorPrincipal.setCenter(contenedorTablero);



        alGoOh.addObserver((o, arg) -> {
            Log.debug("AlGoOh observer");
        });


        alGoOh.siguienteTurno();



        scene = new Scene(contenedorPrincipal, 1200, 800);
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

    private void llenarContenedorTablero(ArrayList<Jugador> jugadores,VBox contenedorJugadores){
        contenedorJugadores.setAlignment(Pos.CENTER);
        for (Jugador j : jugadores){
            Pane pane = new Pane();
            contenedorJugadores.getChildren().add(pane);
            new TableroVista(j,pane);
        }
    }
}

