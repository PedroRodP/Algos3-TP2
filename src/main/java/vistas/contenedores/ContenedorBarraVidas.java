package main.java.vistas.contenedores;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import main.java.general.Jugador;
import main.java.vistas.JugadorVista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class ContenedorBarraVidas {
        private HashMap<Jugador,JugadorVista> mapJugadores ;
        private ArrayList<Jugador> jugadores;
        private VBox contenedor;

    public ContenedorBarraVidas(HashMap<Jugador,JugadorVista> mapJugadores, ArrayList<Jugador> jugadores, Pane pane) {

        this.mapJugadores = mapJugadores;
        this.jugadores = jugadores;
        contenedor = new VBox(250);
        contenedor.setAlignment(Pos.CENTER);
        actualizar();
        pane.getChildren().add(contenedor);
        for (Jugador j:jugadores){
            j.addObserver( (o1, arg) -> {
              actualizar();
            });
        }
    }

    public void actualizar(){
        contenedor.getChildren().clear();
        for (Jugador jug: jugadores){
            JugadorVista vistaJug = mapJugadores.get(jug);

            VBox vida = new VBox(10);
            vida.setAlignment(Pos.CENTER);

            Label vidaTexto = new Label(vistaJug.obtenerNombre()+" :\n"+ jug.obtenerPuntosDeVida()+"/8000");
            vidaTexto.setFont(new Font(20));
            vidaTexto.setTextFill(Paint.valueOf("white"));

            vida.getChildren().addAll(vidaTexto,porgresBar(jug.obtenerPuntosDeVida()));
            contenedor.getChildren().add(vida);
        }
    }

    public ProgressBar porgresBar(double vida){
        ProgressBar vidaBarra = new ProgressBar(0);
        cambiarPropiedadesBarra(vidaBarra);
        Task task = taskCreator(vida);
        vidaBarra.progressProperty().unbind();
        vidaBarra.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        vidaBarra.setPrefWidth(140);

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
