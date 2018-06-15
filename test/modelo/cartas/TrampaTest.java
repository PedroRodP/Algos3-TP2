package modelo.cartas;

import org.junit.Test;

import main.java.cartas.trampa.Trampa;
import main.java.tablero.Tablero;

import static org.junit.Assert.assertEquals;

public class TrampaTest {


    @Test
    public void test01ColocarUnaCartaTrampaEnTablero() {
        Trampa carta = new Trampa("Cilindro Magico");
        Tablero tablero = new Tablero();
        tablero.agregarCarta(carta);

        assertEquals(carta,tablero.obtenerCartaTrampa("Cilindro Magico"));
    }
    
/*    @Test
    public void test02SiColocarUnaCartaTrampaBocaAbajoEnTableroEstaBocaArribaEsFalse() {
        Trampa carta = new Trampa("Cilindro Magico");
        Tablero tablero = new Tablero();
        tablero.agregarCarta(carta);

        assertEquals(false,carta.estaBocaArriba());
    }
    */
    

}
