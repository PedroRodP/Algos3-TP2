package main.java.vistas.cartas;

import javafx.scene.layout.GridPane;
import main.java.cartas.campo.Campo;

public class CampoVista extends CartaVista {
    public CampoVista(Campo campo, GridPane paneCartaCampo) {
        super(campo,paneCartaCampo);
    }

    @Override
    protected void actualizarAcciones() {}
}
