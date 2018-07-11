package main.java.excepciones;

public class ExcepcionSacrificiosInsuficientes extends ExcepcionAlGoOh {
	
    private int sacrificiosNecesarios;
    
    public ExcepcionSacrificiosInsuficientes(int sacrificios){
        sacrificiosNecesarios = sacrificios;
    }

    public int obtenerSacrificiosNecesarios() {
        return sacrificiosNecesarios;
    }
}
