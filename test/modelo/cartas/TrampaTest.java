package modelo.cartas;

import modelo.Tablero.Tablero;
import modelo.cartas.magica.Magica;
import modelo.cartas.trampa.Trampa;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrampaTest {


    @Test
    public void test01ColocarUnaCartaTrampaEnCampo() {
        Trampa unaCarta= new Trampa("Cilindro Magico");
        Tablero unTablero= new Tablero();
        unaCarta.agregarEn(unTablero);

        assertEquals(unaCarta,unTablero.obtenerCartaTrampa("Cilindro Magico"));
    }

}
