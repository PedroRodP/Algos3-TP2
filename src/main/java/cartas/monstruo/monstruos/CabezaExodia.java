package main.java.cartas.monstruo.monstruos;

public class CabezaExodia extends Exodia {

    public CabezaExodia(){
        super(1000,1000,3);
        nombre = "Exodia, el prohibido";
    }

    @Override
    public boolean esCabezaDeExodia() {
        return true;
    }
}
