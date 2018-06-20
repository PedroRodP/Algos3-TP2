package main.java.cartas.monstruo.monstruos.exodia;

public class BrazoDerechoExodia extends Exodia{

    public BrazoDerechoExodia(){
        super(200,300,1);
        nombre = "Brazo Derecho del Prohibido";
    }

    @Override
    public boolean esBrazoDerechoDeExodia() {
        return true;
    }
}
