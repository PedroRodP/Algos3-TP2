package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.LinkedList;


public class Alerta {

    public static void display(String titulo, Node nodo){
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(250);


        Button cerrar = new Button("Cerrar");
        cerrar.setOnAction(event -> {ventana.close();});

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nodo,cerrar);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    public static void sacrificiosInsuficientes(int necesarios){
        Alerta.display("Atención",
                new Label("La carta requiere " + necesarios + " sacrificios.")
        );
    }

    public static void faseIncorrecta(){
        Alerta.display("Atención",
                new Label("Fase incorrecta.")
        );
    }

    public static void monstruoNoPuedeAtacar(String causa) {
        Alerta.display("Monstruo no puede atacar",
                new Label(causa));
    }

    public static void ZonaCompleta() {
        Alerta.display("Alerta",
                new Label("Zona completa"));
    }


    public static LinkedList<String> menuPrincipal(){
        LinkedList<String> nombres = new LinkedList<>();
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Menu principal");
        ventana.setMinWidth(300);
        ventana.setMinHeight(300);


        VBox layout = new VBox(10);

        TextField jugador1 = new TextField("Jugador 1");
        jugador1.setMaxWidth(150);
        TextField jugador2 = new TextField("Jugador 2");
        jugador2.setMaxWidth(150);

        String nombre1 = jugador1.getText();
        String nombre2 = jugador2.getText();
        nombres.add(nombre1);
        nombres.add(nombre2);
        Button botonInicio = new Button("Iniciar juego");
        botonInicio.setOnAction(event -> {
            String nombre10 = jugador1.getText();
            String nombre20 = jugador2.getText();
            nombres.set(0,nombre10);
            nombres.set(1,nombre20);
            ventana.close();}
        );

        layout.getChildren().addAll(jugador1,jugador2,botonInicio);
        layout.setAlignment(Pos.CENTER);
        StackPane stack = new StackPane();
        Image imagen = new Image("main/java/imagenes/otras/yugimenu.jpg");
        BackgroundImage backImage = new BackgroundImage(imagen,null,null,null,
                new BackgroundSize(0,0,false,false,false,true));
        stack.getChildren().addAll(layout);
        stack.setBackground(new Background(backImage));
        Scene escena = new Scene(stack);
        ventana.getIcons().clear();
        ventana.getIcons().add(new Image("main/java/imagenes/cartas/Carta_dada_vuelta.jpg"));
        ventana.setScene(escena);
        ventana.showAndWait();

        return nombres;
    }
}


