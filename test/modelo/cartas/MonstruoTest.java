package modelo.cartas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.cartas.monstruo.Monstruo;
import modelo.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import modelo.general.Jugador;

public class MonstruoTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ColocarUnMonstruoEnPosicionDeAtaqueUtilizaValorDeAtaque() {
		
		Monstruo monstruo = new Monstruo(1000, 500, "dragon"); //Ataque, defensa, nombre
		
		monstruo.colocarEnAtaque();
		
		assertEquals(1000, monstruo.vida(), DELTA);
	}
	
	@Test
	public void test02ColocarUnMonstruoEnPosicionDeDefensaUtilizaValorDeDefensa() {
		
		Monstruo monstruo = new Monstruo(1000, 500,"dragon azul");
		
		monstruo.colocarEnDefensa();
		
		assertEquals(500, monstruo.vida(), DELTA);
	}
	
	@Test
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador jugador = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000,500,"dragon azul");
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new Monstruo(1100,500, "dragon verde");
		monstruoVerde.colocarEnAtaque();
		
		jugador.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000 - (1100-1000),jugador.vida(),DELTA);
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new Monstruo(1000,500,"dragon azul");
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new Monstruo(1100,500, "dragon verde");
		monstruoVerde.colocarEnAtaque();
		
		jugadorA.atacar(monstruoVerde,monstruoAzul);
		
		assertEquals(8000 - (1100-1000),jugadorB.vida(),DELTA);
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInflingenDanio() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000,500,"dragon azul");
		Monstruo monstruoVerde = new Monstruo(1000,500, "dragon verde");
		
		atacante.establecerOponente(oponente);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnAtaque();
		
		atacante.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000, atacante.vida(), DELTA);
		assertEquals(8000, oponente.vida(), DELTA);
	}

	@Test
	public void test06MonstruoEnAtaqueAtacaAMonstruoConMenorDefensaYSeDestruyeSinInflingirDanio() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000, 500, "dragon azul");
		Monstruo monstruoVerde = new Monstruo(1000, 500, "dragon verde");
		
		atacante.establecerOponente(oponente);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000, oponente.vida(), DELTA);
	}
}
