package main.java.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionMonstruoYaAtaco;

public class MonstruoRivalVista extends MonstruoGeneralVista {


    public MonstruoRivalVista(Monstruo monstruo,GridPane pane) {
        super(monstruo, pane);

        accionCartaVista.agregarAccion("seleccionar", event -> {
            if (!seleccionado) Main.desseleccionarMonstruos();
            altenarSeleccionar();
        });
    }

}
