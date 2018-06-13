package modelo.cartas;

import modelo.Tablero.Tablero;
import modelo.cartas.magica.Magica;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicaTest {


        private static final double DELTA = 1e-2;

        @Test
        public void test01ColocarUnaCartaMagiaEnCampo() {
            Magica unaCarta= new Magica("agujero negro");
            Tablero unTablero= new Tablero();
            unaCarta.agregarEn(unTablero);

            assertEquals(unaCarta,unTablero.obtenerCartaMagica("agujero negro"));
        }

        @Test

        public void test02EncuentroCartaMagica(){
            Magica unaCarta= new Magica("agujero negro");
        assertEquals(true,unaCarta.tenesEsteNombre("agujero negro"));
        }
}
	

