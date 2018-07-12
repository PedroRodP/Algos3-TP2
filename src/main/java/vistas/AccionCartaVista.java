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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import main.java.vistas.cartas.CartaVista;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccionCartaVista {
    private GridPane pane;
    private ArrayList<Button> buttons;
    private CartaVista cartaVista;

    public AccionCartaVista(CartaVista cartaVista){
        pane = new GridPane();
        buttons = new ArrayList<>();
        this.cartaVista = cartaVista;

        GridPane.setHalignment(pane,HPos.CENTER);
        ColumnConstraints colum = new ColumnConstraints();
        colum.setPercentWidth(100);
        pane.getColumnConstraints().add(colum);
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
        GridPane.setHalignment(nombre,HPos.CENTER);
        nombre.setTextFill(Paint.valueOf("white"));
        nombre.setFont(new Font(16));
        nombre.setWrapText(true);
        nombre.setStyle("-fx-font-weight: bold;");
        pane.add(nombre,0,0);

        try {
            ImageView imagen = cartaVista.obtenerImagen();
            imagen.setFitHeight(200);
            imagen.setFitWidth(160);
            GridPane.setHalignment(imagen,HPos.CENTER);
            pane.add(imagen,0,1);
        } catch (FileNotFoundException e) {}

        for (int i = 0; i < buttons.size();i++){
            Button b = buttons.get(i);
            GridPane.setHalignment(b,HPos.CENTER);
            pane.add(b,0,i+3);
        }

        return pane;
    }
}
