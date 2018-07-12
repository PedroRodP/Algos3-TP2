package main.java.vistas.zonas;

import javafx.scene.layout.GridPane;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;
import main.java.vistas.cartas.CartaVista;
import main.java.vistas.cartas.MagicaVista;
import main.java.vistas.cartas.TrampaVista;

public class ZonaMagicaPropiaVista extends ZonaMagicaVista{

    public ZonaMagicaPropiaVista(ZonaMagicasYTrampas zona, GridPane pane){
        super(zona,pane);
    }

    @Override
    protected CartaVista obtenerCartaVistaMagica(Magica magica, GridPane gridPane) {
        return new MagicaVista(magica,gridPane);
    }

    @Override
    protected CartaVista obtenerCartaVistaTrampa(Trampa trampa, GridPane gridPane) {
        return new TrampaVista(trampa,gridPane);
    }
}
