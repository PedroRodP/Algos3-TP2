package main.java.cartas.monstruo.monstruos.exodia;

import main.java.cartas.Carta;
import main.java.cartas.monstruo.Monstruo;

import java.util.LinkedList;

public abstract class Exodia extends Monstruo {

    public static boolean estaCompleto(LinkedList<Carta> cartas){
        boolean tieneCabeza = false,tieneBrazoIzq = false,tieneBrazoDer = false,tienePiernaIzq = false,tienePiernaDer = false;
        for (Carta carta : cartas){
            if (carta instanceof Exodia){
                Exodia parteDeExodia = (Exodia) carta;
                tieneCabeza = tieneCabeza || parteDeExodia.esCabezaDeExodia();
                tieneBrazoIzq = tieneBrazoIzq || parteDeExodia.esBrazoIzquierdoDeExodia();
                tieneBrazoDer = tieneBrazoDer || parteDeExodia.esBrazoDerechoDeExodia();
                tienePiernaIzq = tienePiernaIzq || parteDeExodia.esPiernaIzquierdaDeExodia();
                tienePiernaDer = tienePiernaDer || parteDeExodia.esPiernaDerechaDeExodia();

                if (tieneCabeza && tieneBrazoIzq && tieneBrazoDer && tienePiernaIzq && tienePiernaDer){
                    return true;
                }
            }
        }
        return false;
    }

    public Exodia(double ataque,double defensa,int cantidadDeEstrellas){
        super(ataque,defensa,cantidadDeEstrellas);
    }

    public boolean esCabezaDeExodia(){ return false; }
    public boolean esBrazoIzquierdoDeExodia(){ return false; }
    public boolean esBrazoDerechoDeExodia(){ return false; }
    public boolean esPiernaIzquierdaDeExodia(){ return false; }
    public boolean esPiernaDerechaDeExodia(){ return false; }

}