package modelo.cartas;

public class Efecto {

    public void aplicarEfecto(){

        Juego juego= Juego.obtenerJuego();
        juego.DestruirTodosLosMonostruos();
    }
}
