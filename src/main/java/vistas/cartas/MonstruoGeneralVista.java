package main.java.vistas.cartas;

import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.Main;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public abstract class MonstruoGeneralVista extends CartaVista {

    public boolean seleccionado = false;

    public MonstruoGeneralVista(Monstruo monstruo, GridPane pane) {
        super(monstruo, pane);
        girarSiEstaEnDefensa();
        observer = (o, arg) -> {
            girarSiEstaEnDefensa();
        };
        carta.addObserver(observer);
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

    private void girarSiEstaEnDefensa(){
        imagen.setRotate(
                (obtenerMonstruo().estaEnDefensa())? 90 : 0
        );
    }

    @Override
    protected void mostrarImagen() {
        super.mostrarImagen();
        girarSiEstaEnDefensa();
    }

    public Monstruo obtenerMonstruo(){
        return (Monstruo) carta;
    }
}
