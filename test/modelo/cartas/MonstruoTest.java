package modelo.cartas;

import static org.junit.Assert.assertEquals;

import main.java.cartas.monstruo.monstruos.*;
import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
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
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Jugador jugador = new Jugador();
		
		Monstruo monstruoAzul = new AgresorOscuro();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		monstruoVerde.colocarEnAtaque();
		
		jugador.jugarCartaBocaArriba(monstruoAzul);
		jugador.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000 - 1800,jugador.vida(),DELTA);
		assert (jugador.cartaFueDestruida(monstruoAzul));
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new AgresorOscuro();
		monstruoVerde.colocarEnAtaque();
		
		jugadorA.jugarCartaBocaArriba(monstruoAzul);
		jugadorA.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000 - 1800,jugadorB.vida(),DELTA);
		assert (jugadorB.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInfligenDanio() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		
		atacante.establecerOponente(oponente);
		atacante.jugarCartaBocaArriba(monstruoAzul);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnAtaque();
		
		atacante.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000, atacante.vida(), DELTA);
		assertEquals(8000, oponente.vida(), DELTA);
		
		assert (atacante.cartaFueDestruida(monstruoAzul));
		assert (oponente.cartaFueDestruida(monstruoVerde));
	}

	@Test
	public void test06MonstruoEnAtaqueAtacaAMonstruoConMenorDefensaYSeDestruyeSinInfligirDanio() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		Monstruo monstruoVerde = new AgresorOscuro();
		
		atacante.establecerOponente(oponente);
		atacante.jugarCartaBocaArriba(monstruoAzul);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000, oponente.vida(), DELTA);
		assert (oponente.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test07MonstruoEnAtaqueAtacaAMonstruoConMayorDefensaYNoSeDestruyeNiInfligeDanio() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		
		atacante.establecerOponente(oponente);
		atacante.jugarCartaBocaArriba(monstruoAzul);
		
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

	@Test
	public void testo10ActivoEfectoJinzoYAtacoALosPuntosDeVidaDirectamente() throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar {
		Jugador jugador = new Jugador();
		Jugador rival = new Jugador();
		rival.establecerOponente(jugador);
		jugador.establecerOponente(rival);

		Monstruo monstruo = new AgresorOscuro();
		
		Jinzo7 jinzo7 = new Jinzo7();
		jinzo7.afectaA(rival);

		rival.jugarCartaBocaAbajo(monstruo);
		jugador.jugarCartaBocaArriba(jinzo7);
		jinzo7.colocarEnAtaque();
		
		jinzo7.aplicarEfecto();
		
		assertEquals(7500,rival.vida(),DELTA);
	}
	
	@Test
	public void test12CuandoAlterarAtaqueCon200PuntosAMonstruoEsteIncrementaSuPotencialEn200Puntos() {
    
		Monstruo monstruoA = new AgresorOscuro();
    
		double ataqueMonstruoA = monstruoA.potenciaDeCombate();
    
		monstruoA.colocarEnAtaque();
		monstruoA.alterarAtaque(200);
    
		assertEquals(ataqueMonstruoA + 200, monstruoA.potenciaDeCombate(), DELTA);	
   
	}

	@Test
	public void test13Invoco3DragonesDeOjosAzulesYDragonDefinitivoDeOjosAzulesSacrificando3Dragones(){

		Jugador jugador = new Jugador();
		Monstruo monstruoVerde = new AgresorOscuro();
		Monstruo monstruoRojo = new AgresorOscuro();
		Monstruo monstruoVioleta = new AgresorOscuro();
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoRosa = new AgresorOscuro();
		Monstruo monstruoAmarillo = new AgresorOscuro();

		jugador.jugarCartaBocaAbajo(monstruoAmarillo);
		jugador.jugarCartaBocaAbajo(monstruoAzul);
		jugador.jugarCartaBocaAbajo(monstruoRojo);
		jugador.jugarCartaBocaAbajo(monstruoRosa);
		jugador.jugarCartaBocaAbajo(monstruoVerde);
		jugador.jugarCartaBocaAbajo(monstruoVioleta);

		Monstruo dragon1 = new DragonBlancoDeOjosAzules();
		Monstruo dragon2 = new DragonBlancoDeOjosAzules();
		Monstruo dragon3 = new DragonBlancoDeOjosAzules();

		jugador.jugarCartaBocaAbajo(dragon1);
		jugador.jugarCartaBocaAbajo(dragon2);
		jugador.jugarCartaBocaAbajo(dragon3);

		Monstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules();

		jugador.jugarCartaBocaAbajo(dragonDefinitivo);

		assert (jugador.cartaFueDestruida(dragon1));
		assert (jugador.cartaFueDestruida(dragon2));
		assert (jugador.cartaFueDestruida(dragon3));

	}
}
