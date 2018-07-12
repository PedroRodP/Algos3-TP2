package main.java.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import main.java.vistas.cartas.CartaVista;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccionCartaVista {
    private VBox pane;
    private ArrayList<Button> buttons;
    private CartaVista cartaVista;

    public AccionCartaVista(CartaVista cartaVista){
        pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        buttons = new ArrayList<>();
        this.cartaVista = cartaVista;
    }

    public void borrarAcciones(){
        buttons.clear();
    }

    public void agregarAccion(String mensaje, EventHandler<ActionEvent> eventHandler){
        Button button = new Button(mensaje);
        button.setOnAction(eventHandler);
        buttons.add(button);
    }

    public Node obtenerVista() {
        pane.getChildren().clear();

        Label nombre = new Label(cartaVista.obtenerNombre());
        nombre.setTextFill(Paint.valueOf("white"));
        nombre.setFont(new Font(16));
        nombre.setWrapText(true);
        nombre.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(nombre);

        try {
            ImageView imagen = cartaVista.obtenerImagen();
            imagen.setFitHeight(200);
            imagen.setFitWidth(160);
            pane.getChildren().add(imagen);
        } catch (FileNotFoundException e) {}

        for (int i = 0; i < buttons.size();i++){
            Button b = buttons.get(i);
            pane.getChildren().add(b);
        }

        return pane;
    }
}
