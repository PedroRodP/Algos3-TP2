package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
        ventana.setTitle("menu principal");
        ventana.setMinWidth(300);
        ventana.setMinHeight(300);


        VBox layout = new VBox(10);
        TextField jugador1 = new TextField("nombre jugador 1");
        TextField jugador2 = new TextField("nombre jugador 2");
        String nombre1 = jugador1.getText();
        String nombre2 = jugador2.getText();
        nombres.add(nombre1);
        nombres.add(nombre2);
        Button botonInicio = new Button("iniciar juego");
        botonInicio.setOnAction(event -> {
            String nombre10 = jugador1.getText();
            String nombre20 = jugador2.getText();
            nombres.set(0,nombre10);
            nombres.set(1,nombre20);
            ventana.close();}
        );

        layout.getChildren().addAll(jugador1,jugador2,botonInicio);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout);
        ventana.setScene(escena);
        ventana.showAndWait();

        return nombres;
    }
}


