package main.java.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionMonstruoYaAtaco;


public class MonstruoVista extends MonstruoGeneralVista  {


    public MonstruoVista(Monstruo monstruo,GridPane pane) {
        super(monstruo,pane);

        accionCartaVista.agregarAccion("Seleccionar", event -> {
            altenarSeleccionar();
        });

        accionCartaVista.agregarAccion("voltear carta", event -> {
            try {
                Main.alGoOh.voltearCarta(monstruo);
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            }
        });

        accionCartaVista.agregarAccion("Colocar en ataque",event -> {
            try {
                Main.alGoOh.colocarEnAtaque(monstruo);
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            }
        });

        accionCartaVista.agregarAccion("Colocar en defensa",event -> {
            try {
                Main.alGoOh.colocarEnDefensa(monstruo);
            } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                Alerta.faseIncorrecta();
            }
        });

        accionCartaVista.agregarAccion("Aplicar efecto",event -> {
            for (MonstruoGeneralVista m : Main.obtenerMonstruosSeleccionados()){
                try {
                    Main.alGoOh.aplicarEfectoDeMonstruo(monstruo,m.obtenerMonstruo());
                } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                    Alerta.faseIncorrecta();
                }
                return;
            }
            Alerta.display("Atención",new Label("Debe seleccionar un monstruo."));
        });

        accionCartaVista.agregarAccion("atacar", event -> {
            try {
                Main.alGoOh.atacarCon(monstruo,Main.obtenerMonstruosSeleccionados().get(0).obtenerMonstruo());
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
