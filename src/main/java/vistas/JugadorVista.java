package main.java.vistas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import main.java.general.Jugador;

public class JugadorVista {
    private Jugador jugador;
    private Jugador oponente;
    private Pane pane;
    private String nombre;


    public JugadorVista(Jugador jugador, String nombre) {
        this.jugador = jugador;
        this.nombre = nombre;
        oponente = jugador.obtenerOponente();

        generarVista();

    }

    private void generarVista(){
        pane = new VBox(200);

        Label turnoActual = new Label("TURNO ACTUAL:\n"+nombre);
        turnoActual.setTextFill(Paint.valueOf("orange"));
        turnoActual.setFont(new Font(18));
        pane.getChildren().add(turnoActual);
    }



    public String obtenerNombre(){
        return nombre;
    }

    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public Node obtenerVista(){
        return pane;
    }


}


