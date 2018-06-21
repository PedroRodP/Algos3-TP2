package modelo.cartas;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

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
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		
		aSacrificar.add(monstruoAzul);
		
		jugador.jugarMonstruoBocaAbajo(monstruoAzul);
		jugador.jugarMonstruoBocaAbajoSacrificando(monstruoRojo, aSacrificar);
		
		assert (jugador.cartaFueDestruida(monstruoAzul));
		
	}
	
	@Test
	public void test09InvocacionAMonstruoDe8EstrellasSacrificaAMonstruoEnTablero() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoVerde = new AgresorOscuro();
		Monstruo monstruoRojo = new AgresorOscuro();
		Monstruo monstruoAzul = new DragonBlancoDeOjosAzules();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		
		aSacrificar.add(monstruoRojo);
		aSacrificar.add(monstruoVerde);

		jugador.jugarMonstruoBocaAbajo(monstruoRojo);
		jugador.jugarMonstruoBocaAbajo(monstruoVerde);
		jugador.jugarMonstruoBocaAbajoSacrificando(monstruoAzul, aSacrificar);
		
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
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		LinkedList<Monstruo> dragones = new LinkedList<>();
		
		Monstruo dragon1 = new DragonBlancoDeOjosAzules();
		Monstruo dragon2 = new DragonBlancoDeOjosAzules();
		Monstruo dragon3 = new DragonBlancoDeOjosAzules();
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		aSacrificar.add(aux);
		aSacrificar.add(aux);
		dragones.add(dragon1);
		dragones.add(dragon2);
		dragones.add(dragon3);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon1, aSacrificar);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon2, aSacrificar);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon3, aSacrificar);

		jugador.jugarMonstruoBocaAbajoSacrificando(definitivo, dragones);

		assert (jugador.cartaFueDestruida(dragon1));
		assert (jugador.cartaFueDestruida(dragon2));
		assert (jugador.cartaFueDestruida(dragon3));
	}
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void test14InvocarDragonDefinitivoSinTenerDragonesBlancosLanzaExcepcion() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		
		Monstruo aux = new AgresorOscuro();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>(); //3 monstruos que no son dragones
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		aSacrificar.add(aux);
		aSacrificar.add(aux);
		aSacrificar.add(aux);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajoSacrificando(definitivo, aSacrificar);
	}
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void test15InvocarDragonDefinitivoConMenosDe3DragonesBlancosLanzaExcepcion() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		
		Monstruo aux = new AgresorOscuro();
		Monstruo dragon = new DragonBlancoDeOjosAzules();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>(); //2 monstruos para agregar un dragon blanco
		LinkedList<Monstruo> dragones = new LinkedList<>(); //Menos de 3 dragones
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		aSacrificar.add(aux);
		aSacrificar.add(aux);
		dragones.add(dragon);
		dragones.add(dragon);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon, aSacrificar);
		
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajo(aux);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon, aSacrificar);
		
		jugador.jugarMonstruoBocaAbajoSacrificando(definitivo, aSacrificar);
	}
	
	@Test
	public void test16SiSeSeleccionanMasMonstruosQueLosNecesariosSeSacrificaranLosNecesariosYSeDestruiranLosDemas() 
			throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {

		Jugador jugador = new Jugador();
		Monstruo dragon = new DragonBlancoDeOjosAzules();
		Monstruo monstruito1 = new AgresorOscuro();
		Monstruo monstruito2 = new AgresorOscuro();
		Monstruo monstruito3 = new AgresorOscuro();
		
		jugador.jugarMonstruoBocaAbajo(monstruito1);
		jugador.jugarMonstruoBocaAbajo(monstruito2);
		jugador.jugarMonstruoBocaAbajo(monstruito3);
		
		LinkedList<Monstruo> todos = jugador.obtenerMonstruos();
		
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon, todos);
		
		assert (jugador.cartaFueDestruida(monstruito1));
		assert (jugador.cartaFueDestruida(monstruito2));
		assert (jugador.cartaFueDestruida(monstruito3));
	}
	
}
