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
		
		Monstruo monstruo = new Monstruo(1000, 500, 1,  "dragon"); //Ataque, defensa, nombre
		
		monstruo.colocarEnAtaque();
		
		assertEquals(1000, monstruo.potenciaDeCombate(), DELTA);
	}
	
	@Test
	public void test02ColocarUnMonstruoEnPosicionDeDefensaUtilizaValorDeDefensa() {
		
		Monstruo monstruo = new Monstruo(1000, 500, 1, "dragon azul");
		
		monstruo.colocarEnDefensa();
		
		assertEquals(500, monstruo.potenciaDeCombate(), DELTA);
	}
	
	@Test
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador jugador = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000,500, 2,"dragon azul");
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new Monstruo(1100,500, 2, "dragon verde");
		monstruoVerde.colocarEnAtaque();
		
		jugador.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000 - (1100-1000),jugador.vida(),DELTA);
		assert (jugador.cartaFueDestruida(monstruoAzul));
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new Monstruo(1000,500, 2 ,"dragon azul");
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new Monstruo(1100,500, 2, "dragon verde");
		monstruoVerde.colocarEnAtaque();
		
		jugadorA.atacar(monstruoVerde,monstruoAzul);
		
		assertEquals(8000 - (1100-1000),jugadorB.vida(),DELTA);
		assert (jugadorB.cartaFueDestruida(monstruoAzul));
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInfligenDanio() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000,500, 2,"dragon azul");
		Monstruo monstruoVerde = new Monstruo(1000,500, 2, "dragon verde");
		
		atacante.establecerOponente(oponente);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnAtaque();
		
		atacante.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000, atacante.vida(), DELTA);
		assertEquals(8000, oponente.vida(), DELTA);
		
		assert (atacante.cartaFueDestruida(monstruoAzul));
		assert (oponente.cartaFueDestruida(monstruoVerde));
	}

	@Test
	public void test06MonstruoEnAtaqueAtacaAMonstruoConMenorDefensaYSeDestruyeSinInfligirDanio() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000, 500, 2 , "dragon azul");
		Monstruo monstruoVerde = new Monstruo(1000, 500, 2,  "dragon verde");
		
		atacante.establecerOponente(oponente);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000, oponente.vida(), DELTA);
		assert (oponente.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test07MonstruoEnAtaqueAtacaAMonstruoConMayorDefensaYNoSeDestruyeNiInfligeDanio() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new Monstruo(1000, 500, 2, "dragon azul");
		Monstruo monstruoVerde = new Monstruo(1000, 1500, 2, "dragon verde");
		
		atacante.establecerOponente(oponente);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000, oponente.vida(), DELTA);
		assert (! oponente.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test08InvocacionAMonstruoDe5EstrellasSacrificaAMonstruoEnTablero() {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoAzul = new Monstruo(1000, 500, 2, "dragon azul");
		Monstruo monstruoRojo = new Monstruo(1000, 1500, 5, "dragon verde");
		
		jugador.jugarCartaMonstruoBocaAbajo(monstruoAzul);
		jugador.jugarCartaMonstruoBocaAbajo(monstruoRojo);
		
		assert (jugador.cartaFueDestruida(monstruoAzul));
		
	}
	
	@Test
	public void test08InvocacionAMonstruoDe7EstrellasSacrificaAMonstruoEnTablero() {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoAzul = new Monstruo(1000, 500, 2, "dragon azul");
		Monstruo monstruoVerde = new Monstruo(1000, 1500, 2, "dragon verde");
		Monstruo monstruoRojo = new Monstruo(1000, 1500, 7, "dragon verde");
		
		jugador.jugarCartaMonstruoBocaAbajo(monstruoAzul);
		jugador.jugarCartaMonstruoBocaAbajo(monstruoVerde);
		jugador.jugarCartaMonstruoBocaAbajo(monstruoRojo);
		
		assert (jugador.cartaFueDestruida(monstruoAzul));
		assert (jugador.cartaFueDestruida(monstruoVerde));
	}
	
	
	
}
