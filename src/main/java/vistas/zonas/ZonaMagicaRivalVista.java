
package main.java.vistas.zonas;

import javafx.scene.layout.GridPane;
import main.java.cartas.ZonaMagicasYTrampas;
import main.java.cartas.magica.Magica;
import main.java.cartas.trampa.Trampa;
import main.java.vistas.cartas.CartaVista;
import main.java.vistas.cartas.MagicaRivalVista;
import main.java.vistas.cartas.TrampaVista;

public class ZonaMagicaRivalVista extends ZonaMagicaVista{

    public ZonaMagicaRivalVista(ZonaMagicasYTrampas zona, GridPane pane){
        super(zona,pane);
    }

    @Override
    protected CartaVista obtenerCartaVistaMagica(Magica magica, GridPane gridPane) {
        return new MagicaRivalVista(magica,gridPane);
    }

    @Override
    protected CartaVista obtenerCartaVistaTrampa(Trampa trampa, GridPane gridPane) {
        return new TrampaVista(trampa,gridPane);
    }
}
