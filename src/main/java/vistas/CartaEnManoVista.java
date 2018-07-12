package main.java.vistas;


import javafx.scene.control.Label;
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
                LinkedList<Monstruo> monstruos= new LinkedList<>();
                for (MonstruoGeneralVista mgv : Main.obtenerMonstruosSeleccionados()){
                    monstruos.add(mgv.obtenerMonstruo());}
                Main.desseleccionarMonstruos();

                try {
                    Main.alGoOh.jugarSacrificandoBocaArriba(carta,monstruos);
                } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                    Alerta.faseIncorrecta();
                } catch (ExcepcionSacrificiosInsuficientes excepcionSacrificiosInsuficientes) {
                    Alerta.sacrificiosInsuficientes(e.obtenerSacrificiosNecesarios());
                } catch (ExcepcionZonaIncorrecta excepcionZonaIncorrecta) {
                    excepcionZonaIncorrecta.printStackTrace();
                } catch (ExcepcionCartaNoNecesitaSacrificios excepcionCartaNoNecesitaSacrificios) {
                    excepcionCartaNoNecesitaSacrificios.printStackTrace();
                } catch (ExcepcionZonaCompleta excepcionZonaCompleta) {
                    Alerta.ZonaCompleta();
                }
            } catch (ExcepcionFaseIncorrecta e) {
                Alerta.faseIncorrecta();
            } catch (ExcepcionZonaCompleta e) {
                Alerta.ZonaCompleta();
            } catch (ExcepcionZonaIncorrecta e) {
                throw new RuntimeException();
            }
        });
        accionCartaVista.agregarAccion("Jugar carta boca abajo", event -> {
            try {
                Main.alGoOh.jugarCartaBocaAbajo(carta);
            } catch (ExcepcionSacrificiosInsuficientes e) {
                LinkedList<Monstruo> monstruos= new LinkedList<>();
                for (MonstruoGeneralVista mgv : Main.obtenerMonstruosSeleccionados()){
                    monstruos.add(mgv.obtenerMonstruo());}
                Main.desseleccionarMonstruos();

                try {
                    Main.alGoOh.jugarSacrificandoBocaAbajo(carta,monstruos);
                } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                    Alerta.faseIncorrecta();
                } catch (ExcepcionSacrificiosInsuficientes excepcionSacrificiosInsuficientes) {
                    Alerta.sacrificiosInsuficientes(e.obtenerSacrificiosNecesarios());
                } catch (ExcepcionZonaIncorrecta excepcionZonaIncorrecta) {
                    excepcionZonaIncorrecta.printStackTrace();
                } catch (ExcepcionCartaNoNecesitaSacrificios excepcionCartaNoNecesitaSacrificios) {
                    excepcionCartaNoNecesitaSacrificios.printStackTrace();
                } catch (ExcepcionZonaCompleta excepcionZonaCompleta) {
                    Alerta.ZonaCompleta();
                }
            } catch (ExcepcionFaseIncorrecta e) {
                Alerta.faseIncorrecta();
            } catch (ExcepcionZonaCompleta e) {
                Alerta.ZonaCompleta();
            } catch (ExcepcionZonaIncorrecta e) {
                throw new RuntimeException();
            }
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
