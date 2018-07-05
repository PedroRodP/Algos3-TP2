package main.java.cartas.monstruo.monstruos;

public class BrazoDerechoExodia extends Exodia{

    public BrazoDerechoExodia(){
        super(200,300,1);
        nombre = "Brazo derecho del prohibido";
    }

    @Override
    public boolean esBrazoDerechoDeExodia() {
        return true;
    }
}
