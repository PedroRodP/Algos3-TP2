package main.java.vistas;

import javafx.scene.Node;
import javafx.scene.control.Label;
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

        actualizarActual();
        actualizarOponente();
        jugador.addObserver((o, arg) -> actualizarActual());
        oponente.addObserver((o, arg) -> actualizarOponente());
    }

    private void generarVista(){
        pane = new VBox(200);

        Label turnoActual = new Label("TURNO ACTUAL:\n"+nombre);
        turnoActual.setTextFill(Paint.valueOf("green"));
        pane.getChildren().add(turnoActual);

        Label rival = new Label("Rival:");
        rival.setFont(Font.font(50));

        //TODO terminar
    }

    private void actualizarActual(){
        pane.getChildren().clear();
        pane.getChildren().add(new Label("VIDA: "+jugador.obtenerPuntosDeVida()));
    }

    private void actualizarOponente(){
        pane.getChildren().clear();
        pane.getChildren().add(new Label("VIDA: "+oponente.obtenerPuntosDeVida()));
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
