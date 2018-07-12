package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class ContenedorAccionesVista {
    private GridPane pane;
    private BorderPane cartaVistaPane;
    private Label nombreFase;

    public ContenedorAccionesVista(GridPane pane){
        this.pane = pane;

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        pane.getColumnConstraints().add(col);

        RowConstraints fila1 = new RowConstraints();
        fila1.setPercentHeight(55);
        pane.getRowConstraints().add(fila1);

        RowConstraints fila2 = new RowConstraints();
        fila2.setPercentHeight(45);
        pane.getRowConstraints().add(fila2);

        cartaVistaPane = new BorderPane();
        pane.add(cartaVistaPane,0,0);

        VBox accionesJuegoPane = new VBox();
        pane.add(accionesJuegoPane,0,1);

        Button siguienteTurno = new Button("Siguiente turno");
        siguienteTurno.setOnAction(event -> {
            Main.alGoOh.siguienteTurno();
        });

        Button siguienteFase = new Button("Siguiente fase");
        siguienteFase.setOnAction(event -> {
            try {
                Main.alGoOh.pasarASiguienteFase();
            } catch (ExcepcionTurnoFinalizo excepcionTurnoFinalizo) {
                Main.alGoOh.siguienteTurno();
            } catch (ExcepcionJuegoTerminado excepcionJuegoTerminado) {
                Alerta.display("Juego Terminado",
                    new Label("El juego ha terminado!")
                );
            }
        });

        nombreFase = new Label(Main.alGoOh.obtenerNombreDeFase());
        Main.alGoOh.addObserver((o, arg) -> {
            nombreFase.setText(Main.alGoOh.obtenerNombreDeFase());
        });

        accionesJuegoPane.getChildren().addAll(siguienteTurno,siguienteFase,nombreFase);

    }

    public void mostrarAccion(AccionCartaVista accionCartaVista){
        cartaVistaPane.setCenter(accionCartaVista.obtenerVista());
    }

    public void removerAcciones(){
        cartaVistaPane.getChildren().clear();
    }
}
