package modelo.cartas;

import modelo.cartas.trampa.Trampa;
import modelo.tablero.Tablero;

import org.junit.Test;

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
