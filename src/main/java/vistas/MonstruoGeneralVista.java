package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.Main;

public abstract class MonstruoGeneralVista extends CartaVista {

    public boolean seleccionado = false;

    public MonstruoGeneralVista(Monstruo monstruo, GridPane pane) {
        super(monstruo, pane);
    }

    public void altenarSeleccionar(){
        if (seleccionado) deseleccionar();
        else seleccionar();
    }

    public void deseleccionar(){
        Main.desseleccionar(this);
        destacar(false);
        seleccionado = false;
    }

    public void seleccionar(){
        Main.seleccionar(this);
        destacar(true);
        seleccionado = true;
    }

    public Monstruo obtenerMonstruo(){
        return (Monstruo) carta;
    }
}
