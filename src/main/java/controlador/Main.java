package main.java.controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.cartas.Carta;
import main.java.general.AlGoOh;
import main.java.general.Jugador;
import main.java.vistas.*;
//import org.mortbay.log.Log;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application {
    public static int ANCHO = 1300;
    public static int ALTO = 700;

    private Observer observer;
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
        EscenaJugador.setearCampoAcciones();
        EscenaJugador jugador2 = new EscenaJugador(primaryStage,alGoOh.obtenerJugadores().get(1),"jugador2");
        EscenaJugador jugador1 = new EscenaJugador(primaryStage,alGoOh.obtenerJugadores().get(0),"jugador1");

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
        observer= (o, arg) -> {
            if (jugador1.sosEste(alGoOh.turnoActual())) {
                Alerta.display("cambio de turno", new Label("turno de "+jugador1.obtenerNombre()));
                jugador1.setearEscena();
            }
            else{
                Alerta.display("cambio de turno", new Label("turno de "+jugador2.obtenerNombre()));
                jugador2.setearEscena();

            }

        };
        alGoOh.addObserver(observer);
        if (jugador1.sosEste(alGoOh.turnoActual())) {jugador1.setearEscena();}
        else{ jugador2.setearEscena();
            System.out.println("puto");}
        stage.show();
    }
}

