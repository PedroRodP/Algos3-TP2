package main.java.controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.cartas.Carta;
import main.java.general.AlGoOh;
import main.java.general.Jugador;
import main.java.vistas.*;
//import org.mortbay.log.Log;

import java.util.ArrayList;

public class Main extends Application {
    public static int ANCHO = 1300;
    public static int ALTO = 700;


    public static AlGoOh alGoOh;
    private static Scene scene;
    private static Stage stage;
    private static ArrayList<MonstruoVista> monstruoVistaSeleccionados = new ArrayList<>();
    private static ContenedorAccionesVista contenedorAcciones;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Yu Gi Oh");
        alGoOh= new AlGoOh();
        EscenaJugador jugador1 = new EscenaJugador(stage,alGoOh.obtenerJugadores().get(0));
        EscenaJugador jugador2 = new EscenaJugador(stage,alGoOh.obtenerJugadores().get(1));
        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
        jugador1.setearEscena();
        stage.show();
    }
}

