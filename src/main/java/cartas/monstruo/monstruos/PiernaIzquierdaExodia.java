package main.java.cartas.monstruo.monstruos;

public class PiernaIzquierdaExodia extends Exodia {
    public PiernaIzquierdaExodia(){
        super(200,300,1);
        nombre = "Pierna izquierda del prohibido";
    }

    @Override
    public boolean esPiernaIzquierdaDeExodia() {
        return true;
    }
}
