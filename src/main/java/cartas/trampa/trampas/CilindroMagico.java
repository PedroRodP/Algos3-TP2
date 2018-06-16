package main.java.cartas.trampa.trampas;

import main.java.cartas.trampa.Trampa;
import main.java.efectos.EfectoCilindroMagico;

public class CilindroMagico  extends Trampa {

    public CilindroMagico(){
        NOMBRE = "Cilindro Magico";
        efecto = new EfectoCilindroMagico();
    }

}
