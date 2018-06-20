package main.java.cartas.monstruo.monstruos.exodia;

public class BrazoIzquierdoExodia extends Exodia {

    public BrazoIzquierdoExodia(){
        super(200,300,1);
        nombre = "Brazo Izquierdo del Prohibido";
    }

    @Override
    public boolean esBrazoIzquierdoDeExodia() {
        return true;
    }
}
