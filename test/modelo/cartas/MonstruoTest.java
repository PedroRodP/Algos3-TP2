package modelo.cartas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.Aitsu;
import main.java.cartas.monstruo.monstruos.DragonBlancoDeOjosAzules;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.general.Jugador;

public class MonstruoTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ColocarUnMonstruoEnPosicionDeAtaqueUtilizaValorDeAtaque() {
		
		Monstruo monstruo = new DragonBlancoDeOjosAzules();
		
		monstruo.colocarEnAtaque();
		
		assertEquals(3000, monstruo.potenciaDeCombate(), DELTA);
	}
	
	@Test
	public void test02ColocarUnMonstruoEnPosicionDeDefensaUtilizaValorDeDefensa() {
		
		Monstruo monstruo = new DragonBlancoDeOjosAzules();
		
		monstruo.colocarEnDefensa();
		
		assertEquals(2500, monstruo.potenciaDeCombate(), DELTA);
	}
	
	@Test
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador jugador = new Jugador();
		
		Monstruo monstruoAzul = new AgresorOscuro();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		monstruoVerde.colocarEnAtaque();
		
		jugador.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000 - 1800,jugador.vida(),DELTA);
		assert (jugador.cartaFueDestruida(monstruoAzul));
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new AgresorOscuro();
		monstruoVerde.colocarEnAtaque();
		
		jugadorA.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000 - 1800,jugadorB.vida(),DELTA);
		assert (jugadorB.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInfligenDanio() throws ExcepcionMonstruoNoPuedeAtacar {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		
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
		
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		Monstruo monstruoVerde = new AgresorOscuro();
		
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
		
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		
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
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoRojo = new Aitsu();
		
		jugador.jugarCartaBocaAbajo(monstruoAzul);
		jugador.jugarCartaBocaAbajo(monstruoRojo);
		
		assert (jugador.cartaFueDestruida(monstruoAzul));
		
	}
	
	@Test
	public void test09InvocacionAMonstruoDe8EstrellasSacrificaAMonstruoEnTablero() {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoVerde = new AgresorOscuro();
		Monstruo monstruoRojo = new AgresorOscuro();
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();

		jugador.jugarCartaBocaAbajo(monstruoRojo);
		jugador.jugarCartaBocaAbajo(monstruoVerde);
		jugador.jugarCartaBocaAbajo(monstruoAzul);
		
		assert (jugador.cartaFueDestruida(monstruoRojo));
		assert (jugador.cartaFueDestruida(monstruoVerde));
	}
	
	
	
}
