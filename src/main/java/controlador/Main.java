package main.java.controlador;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.general.AlGoOh;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application {
    private static AlGoOh alGoOh;

    public static void main(String[] args) {
        alGoOh = new AlGoOh();
        alGoOh.addObserver((o, arg) -> {

        });
        alGoOh.siguienteTurno();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

