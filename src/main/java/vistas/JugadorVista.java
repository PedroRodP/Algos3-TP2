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

        actualizarActual();
        //actualizarOponente();
        jugador.addObserver((o, arg) -> actualizarActual());
        //oponente.addObserver((o, arg) -> actualizarOponente());
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
        VBox vida= new VBox(10);
        vida.getChildren().addAll(new Label("VIDA "+nombre+" :"+jugador.obtenerPuntosDeVida()),porgresBar(jugador.obtenerPuntosDeVida()));
        pane.getChildren().add(vida);
    }

    private void actualizarOponente(){
        pane.getChildren().clear();
        VBox vida= new VBox(10);
        vida.getChildren().addAll(new Label("VIDA: "+oponente.obtenerPuntosDeVida()),porgresBar(oponente.obtenerPuntosDeVida()));
        pane.getChildren().add(vida);
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

    public ProgressBar porgresBar(double vida){
        ProgressBar vidaBarra = new ProgressBar(0);
        cambiarPropiedadesBarra(vidaBarra);
        Task task = taskCreator(vida);
        vidaBarra.progressProperty().unbind();
        vidaBarra.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        vidaBarra.setOnMousePressed(event -> Alerta.display("vida restante",new Label("vida: "+vida)));
        return vidaBarra;
    }

    private void cambiarPropiedadesBarra(ProgressBar vidaBarra) {
        vidaBarra.progressProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.doubleValue()>0.66)
              {
                vidaBarra.setStyle("-fx-accent: green");
              }else{
                    if (newValue.doubleValue() > 0.33)
                      {
                        vidaBarra.setStyle("-fx-accent: yellow");
                      }else {vidaBarra.setStyle("-fx-accent: red");}
                   }

        });
    }

    private Task taskCreator(double vida) {

        return new Task() {
            @Override
            protected Object call() throws Exception {
                updateProgress(vida,8000);
                return true;
            }
        };
    }
}


