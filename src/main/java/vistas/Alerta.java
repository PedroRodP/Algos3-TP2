package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Alerta {

    public static void display(String titulo, Node nodo){
        Stage ventana = new Stage();
        //nodo.setFitHeight(200);
        //nodo.setFitWidth(150);
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
}


