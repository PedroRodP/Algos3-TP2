package main.java.vistas;


import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.GeneradorDeImagenes;
import main.java.controlador.Main;
import main.java.excepciones.*;

import java.io.FileNotFoundException;
import java.util.LinkedList;

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
            } catch (ExcepcionAlGoOh e) {      }
        });
        accionCartaVista.agregarAccion("jugar carta boca arriba sacrificando",event -> {
            LinkedList<Monstruo> monstruos= new LinkedList<>();
            while (!EscenaJugador.obtenerMonstruosSeleccionados().isEmpty()){
                MonstruoGeneralVista sacrificio = EscenaJugador.obtenerMonstruosSeleccionados().get(0);
                monstruos.add(sacrificio.obtenerMonstruo());
                sacrificio.seleccionar();
            }

            try {
                Main.alGoOh.jugarSacrificandoBocaArriba(carta,monstruos);
                for (MonstruoGeneralVista m: EscenaJugador.obtenerMonstruosSeleccionados()){m.seleccionar();}
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            } catch (ExcepcionSacrificiosInsuficientes e) {
                Alerta.sacrificiosInsuficientes(e.obtenerSacrificiosNecesarios());
            } catch (ExcepcionZonaCompleta excepcionZonaCompleta) {
                Alerta.ZonaCompleta();
            } catch (ExcepcionAlGoOh excepcionCartaNoNecesitaSacrificios) {}
            });

        accionCartaVista.agregarAccion("jugar carta boca abajo Sacrificando", event -> {
            LinkedList<Monstruo> monstruos= new LinkedList<>();
            for (MonstruoGeneralVista m : EscenaJugador.obtenerMonstruosSeleccionados()) {
                monstruos.add(m.obtenerMonstruo());
                m.seleccionar();
            }
            try {
                Main.alGoOh.jugarSacrificandoBocaAbajo(carta,monstruos);
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            } catch (ExcepcionSacrificiosInsuficientes e) {
                Alerta.sacrificiosInsuficientes(e.obtenerSacrificiosNecesarios());
            } catch (ExcepcionZonaCompleta excepcionZonaCompleta) {
                Alerta.ZonaCompleta();
            } catch (ExcepcionAlGoOh excepcionCartaNoNecesitaSacrificios) {}

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
