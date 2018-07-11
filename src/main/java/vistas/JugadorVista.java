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
    private VBox paneVidaMia;
    private VBox paneVidaRival;

    public JugadorVista(Jugador jugador, String nombre) {
        this.jugador = jugador;
        this.nombre = nombre;
        oponente = jugador.obtenerOponente();

        generarVista();

        this.paneVidaRival = new VBox(20);
        pane.getChildren().add(paneVidaRival);
        actualizarOponente();

        this.paneVidaMia = new VBox(20);
        pane.getChildren().add(paneVidaMia);
        actualizarActual();

        jugador.addObserver((o, arg) -> actualizarActual());
        oponente.addObserver((o, arg) -> actualizarOponente());

    }

    private void generarVista(){
        pane = new VBox(200);

        Label turnoActual = new Label("TURNO ACTUAL:\n"+nombre);
        turnoActual.setTextFill(Paint.valueOf("green"));
        pane.getChildren().add(turnoActual);

        //Label rival = new Label("Rival:");
        //rival.setFont(Font.font(50));


        //TODO terminar
    }

    private void actualizarActual(){
        paneVidaMia.getChildren().clear();
        paneVidaMia.getChildren().addAll(new Label("VIDA "+nombre+" :"+jugador.obtenerPuntosDeVida()),porgresBar(jugador.obtenerPuntosDeVida()));

    }

    private void actualizarOponente(){
        paneVidaRival.getChildren().clear();
        paneVidaRival.getChildren().addAll(new Label("VIDA Rival: "+oponente.obtenerPuntosDeVida()),porgresBar(oponente.obtenerPuntosDeVida()));

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


