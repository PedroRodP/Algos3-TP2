package main.java.vistas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionMazoVacio;

public class MagicaVista extends CartaVista {
    public MagicaVista(Magica magica, GridPane pane) {
        super(magica,pane);

        accionCartaVista.agregarAccion("Aplicar Magia",event -> {
            try {
                Main.alGoOh.aplicarMagica(magica);
            } catch (ExcepcionCartaBocaAbajo excepcionCartaBocaAbajo) {
                Alerta.display("Atención",
                        new Label("La carta debe estar boca arriba para aplicar magia.")
                );
            } catch (ExcepcionMazoVacio excepcionMazoVacio) {
                Alerta.display("Atención",
                        new Label("El mazo está vacío.")
                );
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.display("Atención",
                        new Label("Fase incorrecta.")
                );
            }
        });

        accionCartaVista.agregarAccion("voltear carta", event -> {
            try {
                Main.alGoOh.voltearCarta(magica);
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            }
        });

    }
}
