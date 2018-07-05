package main.java.cartas.monstruo.monstruos;

public class BrazoIzquierdoExodia extends Exodia {

    public BrazoIzquierdoExodia(){
        super(200,300,1);
        nombre = "Brazo izquierdo del prohibido";
    }

    @Override
    public boolean esBrazoIzquierdoDeExodia() {
        return true;
    }
}
