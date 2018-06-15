package modelo.cartas;

import modelo.general.Jugador;

public class Juego {
    private static Juego juego;
    private Jugador jugador1;
    private Jugador jugador2;

    public static Juego obtenerJuego(){
        if(null==juego){
            juego= new Juego();
        }

        return juego;
    }
    public static Juego obtenerJuego(Jugador jugador1, Jugador jugador2){
        if(null==juego){
            juego= new Juego(jugador1,jugador2);
        }

        return juego;

    }

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Juego() {
    }

    public void DestruirTodosLosMonostruos() {
        this.jugador1.destruirTodosTusMonstruos();
        this.jugador2.destruirTodosTusMonstruos();
    }
}
