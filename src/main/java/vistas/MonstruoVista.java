package main.java.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.java.cartas.monstruo.Monstruo;
import main.java.controlador.Main;
import main.java.excepciones.ExcepcionFaseIncorrecta;


public class MonstruoVista extends CartaVista  {
    public boolean seleccionado = false;

    public MonstruoVista(Monstruo monstruo,GridPane pane) {
        super(monstruo,pane);

        accionCartaVista.agregarAccion("Seleccionar", event -> {
            seleccionar();
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
            for (MonstruoVista m : Main.obtenerMonstruosSeleccionados()){
                try {
                    Main.alGoOh.aplicarEfectoDeMonstruo(monstruo,m.obtenerMonstruo());
                } catch (ExcepcionFaseIncorrecta excepcionFaseIncorrecta) {
                    Alerta.faseIncorrecta();
                }
                return;
            }
            Alerta.display("Atención",new Label("Debe seleccionar un monstruo."));
        });
    }

    public void seleccionar(){
        if (seleccionado) {
            Main.desseleccionar(this);
            destacar(false);
        }else{
            Main.seleccionar(this);
            destacar(true);
        }
        seleccionado = !seleccionado;
    }

    public Monstruo obtenerMonstruo(){
        return (Monstruo) carta;
    }

}
