package main.java.cartas.monstruo.monstruos;

public class PiernaDerechaExodia extends Exodia{
    public PiernaDerechaExodia(){
        super(200,300,1);
        nombre = "Pierna derecha del prohibido";
    }

    @Override
    public boolean esPiernaDerechaDeExodia() {
        return true;
    }
}
