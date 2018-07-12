package main.java.vistas;

import javafx.scene.layout.GridPane;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;

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
