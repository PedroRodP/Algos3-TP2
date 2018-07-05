package main.java.vistas;

import javafx.scene.layout.Pane;

public class ContenedorAccionesVista {
    private Pane pane;

    public ContenedorAccionesVista(Pane pane){
        this.pane = pane;
    }

    public void mostrarAccion(AccionCartaVista accionCartaVista){
        pane.getChildren().add(accionCartaVista.obtenerVista());
    }

    public void removerAcciones(){
        pane.getChildren().clear();
    }
}
