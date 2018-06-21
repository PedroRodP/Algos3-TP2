package modelo.cartas;

import static org.junit.Assert.assertEquals;

import main.java.cartas.monstruo.monstruos.*;
import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionZonaCompleta;
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
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		
		Monstruo monstruoAzul = new AgresorOscuro();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		monstruoVerde.colocarEnAtaque();
		
		jugador.jugarMonstruoBocaArriba(monstruoAzul);
		jugador.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000 - 1800,jugador.vida(),DELTA);
		assert (jugador.cartaFueDestruida(monstruoAzul));
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new AgresorOscuro();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new AmanteFeliz();
		monstruoVerde.colocarEnAtaque();
		
		jugadorA.jugarMonstruoBocaArriba(monstruoAzul);
		jugadorA.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000 - 400,jugadorB.vida(),DELTA);
		assert (jugadorB.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInfligenDanio() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new AmanteFeliz();
		Monstruo monstruoVerde = new AmanteFeliz();
		
		atacante.establecerOponente(oponente);
		atacante.jugarMonstruoBocaArriba(monstruoAzul);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnAtaque();
		
		atacante.atacar(monstruoAzul,monstruoVerde);
		
		assertEquals(8000, atacante.vida(), DELTA);
		assertEquals(8000, oponente.vida(), DELTA);
		
		assert (atacante.cartaFueDestruida(monstruoAzul));
		assert (oponente.cartaFueDestruida(monstruoVerde));
	}

	@Test
	public void test06MonstruoEnAtaqueAtacaAMonstruoConMenorDefensaYSeDestruyeSinInfligirDanio() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoVerde = new AmanteFeliz();
		
		atacante.establecerOponente(oponente);
		atacante.jugarMonstruoBocaArriba(monstruoAzul);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000, oponente.vida(), DELTA);
		assert (oponente.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test07MonstruoEnAtaqueAtacaAMonstruoConMayorDefensaYNoSeDestruyeNiInfligeDanio() throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoVerde = new DragonBlancoDeOjosAzules();
		
		atacante.establecerOponente(oponente);
		atacante.jugarMonstruoBocaArriba(monstruoAzul);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000, oponente.vida(), DELTA);
		assert (! oponente.cartaFueDestruida(monstruoVerde));
	}
	
	@Test
	public void test08InvocacionAMonstruoDe5EstrellasSacrificaAMonstruoEnTablero() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoRojo = new Aitsu();
		
		jugador.jugarMonstruoBocaAbajo(monstruoAzul);
		jugador.jugarMonstruoBocaAbajo(monstruoRojo);
		
		assert (jugador.cartaFueDestruida(monstruoAzul));
		
	}
	
	@Test
	public void test09InvocacionAMonstruoDe8EstrellasSacrificaAMonstruoEnTablero() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoVerde = new AgresorOscuro();
		Monstruo monstruoRojo = new AgresorOscuro();
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();

		jugador.jugarMonstruoBocaAbajo(monstruoRojo);
		jugador.jugarMonstruoBocaAbajo(monstruoVerde);
		jugador.jugarMonstruoBocaAbajo(monstruoAzul);
		
		assert (jugador.cartaFueDestruida(monstruoRojo));
		assert (jugador.cartaFueDestruida(monstruoVerde));
	}

	@Test
	public void testo10ActivoEfectoJinzoYAtacoALosPuntosDeVidaDirectamente() throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		Jugador jugador = new Jugador();
		Jugador rival = new Jugador();
		rival.establecerOponente(jugador);
		jugador.establecerOponente(rival);

		Monstruo monstruo = new AgresorOscuro();
		
		Jinzo7 jinzo7 = new Jinzo7();
		jinzo7.afectaA(rival);

		rival.jugarMonstruoBocaAbajo(monstruo);
		jugador.jugarMonstruoBocaArriba(jinzo7);
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
	public void test13invocacionDragonDefinitivoDeOjosAzulesSacrifica3DragonesDeOjosAzules() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta{
		
		Jugador jugador = new Jugador();
		
		Monstruo aux = new AgresorOscuro(); //Se requieren monstruos para sacrificar para colocar Dragones
		
		Monstruo dragon1 = new DragonBlancoDeOjosAzules();
		Monstruo dragon2 = new DragonBlancoDeOjosAzules();
		Monstruo dragon3 = new DragonBlancoDeOjosAzules();
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(dragon1);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(dragon2);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(dragon3);

		jugador.jugarMonstruoBocaAbajo(definitivo);

		assert (jugador.cartaFueDestruida(dragon1));
		assert (jugador.cartaFueDestruida(dragon2));
		assert (jugador.cartaFueDestruida(dragon3));
	}
}
