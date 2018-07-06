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
    public boolean seleccionado = false;

    public MonstruoRivalVista(Monstruo monstruo,GridPane pane) {
        super(monstruo, pane);

        accionCartaVista.agregarAccion("seleccionar", event -> {
            seleccionar();
        });
    }

    public void seleccionar(){
        if (seleccionado) {
            EscenaJugador.desseleccionar(this);
            destacar(false);
        }else{
            EscenaJugador.seleccionar(this);
            destacar(true);
        }
        seleccionado = !seleccionado;
    }

    public Monstruo obtenerMonstruo(){
        return (Monstruo) carta;
    }
}
