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

        public static void display(String titulo, ImageView nodo){
            Stage ventana = new Stage();
            nodo.setFitHeight(200);
            nodo.setFitWidth(150);
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.setTitle(titulo);
            ventana.setMinWidth(250);


            Button cerrar = new Button("cerrar");
            cerrar.setOnAction(event -> {ventana.close();});

            VBox layout = new VBox(10);
            layout.getChildren().addAll(nodo,cerrar);
            layout.setAlignment(Pos.CENTER);

            Scene escena = new Scene(layout);
            ventana.setScene(escena);
            ventana.showAndWait();

        }
    }

