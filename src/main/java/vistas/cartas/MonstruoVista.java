package main.java.vistas.cartas;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionMonstruoYaAtaco;
import main.java.vistas.Alerta;

import java.util.LinkedList;


public class MonstruoVista extends MonstruoGeneralVista  {


    public MonstruoVista(Monstruo monstruo,GridPane pane) {
        super(monstruo,pane);
    }

    @Override
    protected void actualizarAcciones() {
        Monstruo monstruo = (Monstruo) carta;
        accionCartaVista.agregarAccion("Seleccionar", event -> {
            altenarSeleccionar();
        });

        if (Main.estaEnFasePreparacion()){
            if (!monstruo.estaBocaArriba()){
                accionCartaVista.agregarAccion("Voltear carta", event -> {
                    try {
                        Main.alGoOh.voltearCarta(monstruo);
                    } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                        Alerta.faseIncorrecta();
                    }
                });
            }
            if (monstruo.estaEnDefensa()){
                accionCartaVista.agregarAccion("Colocar en ataque",event -> {
                    try {
                        Main.alGoOh.colocarEnAtaque(monstruo);
                    } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                        Alerta.faseIncorrecta();
                    }
                });
            }else {
                accionCartaVista.agregarAccion("Colocar en defensa",event -> {
                    try {
                        Main.alGoOh.colocarEnDefensa(monstruo);
                    } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                        Alerta.faseIncorrecta();
                    }
                });
            }
        }

        if (Main.estaEnFaseAtaque()){
            accionCartaVista.agregarAccion("Aplicar efecto",event -> {
                for (MonstruoGeneralVista m : Main.obtenerMonstruosSeleccionados()){
                    if (mePertenece(m.obtenerMonstruo())) break;
                    try {
                        Main.alGoOh.aplicarEfectoDeMonstruo(monstruo,m.obtenerMonstruo());
                    } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                        Alerta.faseIncorrecta();
                    }
                    return;
                }
                Alerta.display("Atención",new Label("Debe seleccionar un monstruo rival."));
            });

            accionCartaVista.agregarAccion("Atacar", event -> {
                try {
                    Monstruo m = Main.obtenerMonstruosSeleccionados().get(0).obtenerMonstruo();
                    if (mePertenece(m)){
                        Alerta.display("Atención",new Label("Debe seleccionar un monstruo rival."));
                        return;
                    }
                    Main.alGoOh.atacarCon(monstruo,m);
                    Main.desseleccionarMonstruos();
                } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                    Alerta.faseIncorrecta();
                } catch (ExcepcionMonstruoYaAtaco excepcionMonstruoYaAtaco) {
                    Alerta.monstruoNoPuedeAtacar("monstruo ya ataco este turno");
                } catch (ExcepcionCartaBocaAbajo excepcionCartaBocaAbajo) {
                    Alerta.monstruoNoPuedeAtacar("monstruo esta boca abajo");
                } catch (ExcepcionMonstruoNoPuedeAtacar excepcionMonstruoNoPuedeAtacar) {
                    Alerta.monstruoNoPuedeAtacar("monstruo esta en posicion de defensa");
                }
            });
        }
    }

    public static boolean mePertenece(Monstruo m){
        return Main.alGoOh.turnoActual().obtenerZonaMonstruos().obtenerMonstruos().contains(m);
    }
}
