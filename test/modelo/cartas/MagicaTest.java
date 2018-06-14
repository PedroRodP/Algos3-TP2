package modelo.cartas;

import modelo.cartas.magica.Magica;
import modelo.tablero.Tablero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicaTest {

    @Test
    public void test01ColocarUnaCartaMagiaEnCampo() {
    	
        Magica cartaMagica = new Magica("agujero negro");
        Tablero tablero= new Tablero();
        
        tablero.agregarCarta(cartaMagica);

        assertEquals(cartaMagica , tablero.obtenerCartaMagica("agujero negro"));
    }

    @Test

    public void test02CartaMagicaSeCreaConNombreCorrectamente(){
    	
        Magica carta= new Magica("agujero negro");
        
        assertEquals(true,carta.tenesEsteNombre("agujero negro"));
    }
}
	

