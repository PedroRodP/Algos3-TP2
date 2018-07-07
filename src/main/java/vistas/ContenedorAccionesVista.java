package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionTurnoFinalizo;

public class ContenedorAccionesVista {
    private GridPane pane;
    private Pane cartaVistaPane;
    private GridPane accionesJuegoPane;

    public ContenedorAccionesVista(GridPane pane){
        this.pane = pane;

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        pane.getColumnConstraints().add(col);

        RowConstraints fila1 = new RowConstraints();
        fila1.setPercentHeight(50);
        pane.getRowConstraints().add(fila1);

        RowConstraints fila2 = new RowConstraints();
        fila2.setPercentHeight(50);
        pane.getRowConstraints().add(fila2);

        cartaVistaPane = new Pane();
        pane.add(cartaVistaPane,0,0);

        accionesJuegoPane = new GridPane();
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
                        new Label("El juego ha terminado!"
                        )
                );
            }
        });

        accionesJuegoPane.add(siguienteTurno,0,0);
        accionesJuegoPane.add(siguienteFase,0,1);

    }

    public void mostrarAccion(AccionCartaVista accionCartaVista){
        cartaVistaPane.getChildren().add(accionCartaVista.obtenerVista());
    }

    public void removerAcciones(){
        cartaVistaPane.getChildren().clear();
    }
}
