package main.java.general;

public class Vida {

    private double vida;

    public Vida(double inicial){
        vida = inicial;
    }

    public void quitar(double puntos){
        vida -= puntos;
    }

    public double getVida() {
        return vida;
    }

    public boolean estaMuerto(){
        return vida <= 0; // TODO return Estado
    }

}
