package main.java.vistas.cartas;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.GeneradorDeImagenes;
import main.java.controlador.Main;
import main.java.excepciones.*;
import main.java.vistas.Alerta;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class CartaEnManoVista extends CartaVista {

    public CartaEnManoVista(Carta carta, GridPane pane) {
        super(carta,pane);
    }

    @Override
    protected void actualizarAcciones() {
        if (!Main.estaEnFasePreparacion()) return;

        accionCartaVista.agregarAccion("Jugar carta boca arriba", event -> {
            jugarCarta(true);
        });
        accionCartaVista.agregarAccion("Jugar carta boca abajo", event -> {
           jugarCarta(false);
        });
    }

    private void jugarCarta(boolean bocaArriba){
        try {
        	if (bocaArriba) Main.alGoOh.jugarCartaBocaArriba(carta);
        	else Main.alGoOh.jugarCartaBocaAbajo(carta);
        } catch (ExcepcionSacrificiosInsuficientes e) {
            LinkedList<Monstruo> monstruos= new LinkedList<>();
            for (MonstruoGeneralVista mgv : Main.obtenerMonstruosSeleccionados()){
                if (!MonstruoVista.mePertenece(mgv.obtenerMonstruo())){
                    Alerta.display("Atención",new Label("Debe seleccionar monstruos propios para sacrificar."));
                    return;
                }
                monstruos.add(mgv.obtenerMonstruo());
            }
            Main.desseleccionarMonstruos();

            try {
            	
                if (bocaArriba) Main.alGoOh.jugarSacrificandoBocaArriba(carta,monstruos);
                else Main.alGoOh.jugarSacrificandoBocaAbajo(carta,monstruos);

            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            } catch (ExcepcionSacrificiosInsuficientes e2) {
                Alerta.sacrificiosInsuficientes(e2.obtenerSacrificiosNecesarios());
            } catch (ExcepcionZonaCompleta e2) {
                Alerta.ZonaCompleta();
            } catch (ExcepcionCartaNoNecesitaSacrificios | ExcepcionZonaIncorrecta e2) {
                throw new RuntimeException();
            }

        } catch (ExcepcionFaseIncorrecta e) {
            Alerta.faseIncorrecta();
        } catch (ExcepcionZonaCompleta e) {
            Alerta.ZonaCompleta();
        } catch (ExcepcionZonaIncorrecta e) {
            throw new RuntimeException();
        }
    }

    @Override
    public ImageView obtenerImagen() throws FileNotFoundException {
        return GeneradorDeImagenes.obtenerImagenDelanteraDeCarta(carta);
    }

    @Override
    public String obtenerNombre() {
        return carta.obtenerNombre();
    }

}
