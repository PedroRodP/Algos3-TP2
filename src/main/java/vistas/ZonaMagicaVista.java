package main.java.vistas;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.trampa.Trampa;

import java.util.LinkedList;

public class ZonaMagicaVista {
    public ZonaMagicaVista(ZonaMagicasYTrampas zona, Pane pane) {
        /*
        LinkedList<Magica> magicas=zona.obtenerMagicas();
        LinkedList<Trampa> trampas=zona.obtenerTrampas();
        for(Magica m: magicas){
            StackPane paneMagicas = new StackPane();
            MagicaVista magica =new MagicaVista(m,paneMagica);
            pane.getChildren().add(paneMagica);
            }
        for (Trampa t: trampas ){
            StackPane paneTrampa = new StackPane();
            TrampaVista trampa =new MagicaVista(t,paneTrampa);
            pane.getChildren().add(paneMagica);
            }
        */
        // hay que implementar, obtener magicas y obtener trampas
    }
}
