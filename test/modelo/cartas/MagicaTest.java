package modelo.cartas;

import modelo.cartas.magica.Magica;
import modelo.tablero.Tablero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicaTest {

    @Test
    public void test01ColocarUnaCartaMagiaEnCampo() {
    	
        Magica unaCarta= new Magica("agujero negro");
        Tablero unTablero= new Tablero();
        
        unaCarta.agregarEn(unTablero);

        assertEquals(unaCarta,unTablero.obtenerCartaMagica("agujero negro"));
    }

    @Test

    public void test02CartaMagicaSeCreaConNombreCorrectamente(){
    	
        Magica unaCarta= new Magica("agujero negro");
        
        assertEquals(true,unaCarta.tenesEsteNombre("agujero negro"));
    }
}
	

