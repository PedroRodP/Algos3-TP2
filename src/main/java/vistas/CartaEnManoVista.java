package main.java.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.java.cartas.Carta;
import main.java.controlador.GeneradorDeImagenes;
import main.java.controlador.Main;
import main.java.excepciones.*;

import java.io.FileNotFoundException;

public class CartaEnManoVista extends CartaVista {

    public CartaEnManoVista(Carta carta, GridPane pane) {
        super(carta,pane);

        accionCartaVista.agregarAccion("Jugar carta boca arriba", event -> {
            try {
                Main.alGoOh.jugarCartaBocaArriba(carta);
            } catch (ExcepcionSacrificiosInsuficientes e) {
                Alerta.sacrificiosInsuficientes(e.obtenerSacrificiosNecesarios());
            } catch (ExcepcionAlGoOh e) {}
        });
        accionCartaVista.agregarAccion("Jugar carta boca abajo", event -> {
            try {
                Main.alGoOh.jugarCartaBocaAbajo(carta);
            } catch (ExcepcionSacrificiosInsuficientes e) {
                Alerta.sacrificiosInsuficientes(e.obtenerSacrificiosNecesarios());
            } catch (ExcepcionAlGoOh e) {}
        });
    }

    @Override
    protected ImageView obtenerImagen() throws FileNotFoundException {
        return GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta);
    }

    @Override
    protected String obtenerNombre() {
        return carta.obtenerNombre();
    }

}
