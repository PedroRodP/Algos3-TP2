package modelo.cartas;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import main.java.cartas.monstruo.monstruos.*;
import main.java.excepciones.*;
import org.junit.Test;

import main.java.cartas.monstruo.Monstruo;
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
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque() throws ExcepcionAlGoOh {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		jugador.establecerOponente(oponente);
		oponente.establecerOponente(jugador);
		
		Monstruo agresorOscuro = new AgresorOscuro();
		Monstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		
		agresorOscuro.colocarEnAtaque();
		dragonBlancoDeOjosAzules.colocarEnAtaque();
	
		jugador.jugarCartaBocaArriba(agresorOscuro);
		jugador.atacar(agresorOscuro,dragonBlancoDeOjosAzules);
		
		assertEquals(8000 - 1800,jugador.obtenerPuntosDeVida(),DELTA);
		assert (agresorOscuro.estaEnElCementerio());
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuereYJugadorPierdeVida() throws ExcepcionAlGoOh {
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		jugadorB.establecerOponente(jugadorA);
		
		Monstruo monstruoA = new AgresorOscuro();
		monstruoA.colocarEnAtaque();
		Monstruo monstruoB = new AmanteFeliz();
		monstruoB.colocarEnAtaque();

		jugadorB.jugarCartaBocaAbajo(monstruoB);
		jugadorA.jugarCartaBocaArriba(monstruoA);
		jugadorA.atacar(monstruoA, monstruoB);
		
		assertEquals(8000 - 400,jugadorB.obtenerPuntosDeVida(),DELTA);
		assert (monstruoB.estaEnElCementerio());
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInfligenDanio() throws ExcepcionAlGoOh {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		atacante.establecerOponente(oponente);
		oponente.establecerOponente(atacante);
		
		Monstruo monstruoA = new AmanteFeliz();
		Monstruo monstruoB = new AmanteFeliz();

		oponente.jugarCartaBocaAbajo(monstruoB);
		atacante.jugarCartaBocaArriba(monstruoA);
		
		monstruoA.colocarEnAtaque();
		monstruoB.colocarEnAtaque();
		
		atacante.atacar(monstruoA,monstruoB);
		
		assertEquals(8000, atacante.obtenerPuntosDeVida(), DELTA);
		assertEquals(8000, oponente.obtenerPuntosDeVida(), DELTA);
		
		assert (monstruoA.estaEnElCementerio());
		assert (monstruoB.estaEnElCementerio());
	}

	@Test
	public void test06MonstruoEnAtaqueAtacaAMonstruoConMenorDefensaYSeDestruyeSinInfligirDanio() throws ExcepcionAlGoOh{
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		atacante.establecerOponente(oponente);
		oponente.establecerOponente(atacante);
		
		Monstruo monstruoA = new AgresorOscuro();
		Monstruo monstruoB = new AmanteFeliz();
		
		atacante.jugarCartaBocaArriba(monstruoA);
		atacante.jugarCartaBocaArriba(monstruoB);

		monstruoA.colocarEnAtaque();
		monstruoB.colocarEnDefensa();
		
		atacante.atacar(monstruoA, monstruoB);
		
		assertEquals(8000, oponente.obtenerPuntosDeVida(), DELTA);
		assert (monstruoB.estaEnElCementerio());
	}
	
	@Test
	public void test07MonstruoEnAtaqueAtacaAMonstruoConMayorDefensaYNoSeDestruyeNiInfligeDanio()
			throws ExcepcionAlGoOh {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		atacante.establecerOponente(oponente);
		oponente.establecerOponente(atacante);
		
		Monstruo monstruoA = new AgresorOscuro();
		Monstruo monstruoB = new AbismoReluciente();

		oponente.jugarCartaBocaAbajo(monstruoB);
		atacante.jugarCartaBocaArriba(monstruoA);
		
		monstruoA.colocarEnAtaque();
		monstruoB.colocarEnDefensa();
		
		atacante.atacar(monstruoA, monstruoB);
		
		assertEquals(8000, oponente.obtenerPuntosDeVida(), DELTA);
		assert (! monstruoB.estaEnElCementerio());
	}
	
	@Test
	public void test08InvocacionAMonstruoDe5EstrellasSacrificaAMonstruoEnTablero() throws ExcepcionAlGoOh {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoA = new AgresorOscuro();
		Monstruo monstruoB = new Aitsu();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		
		aSacrificar.add(monstruoA);
		
		jugador.jugarCartaBocaAbajo(monstruoA);
		jugador.jugarCartaBocaAbajoSacrificando(monstruoB, aSacrificar);
		
		assert monstruoA.estaEnElCementerio();
		
	}
	
	@Test
	public void test09InvocacionAMonstruoDe8EstrellasSacrificaAMonstruoEnTablero() throws ExcepcionAlGoOh{
		
		Jugador jugador = new Jugador();
		Monstruo monstruoB = new AgresorOscuro();
		Monstruo monstruoC = new AgresorOscuro();
		Monstruo monstruoA = new DragonBlancoDeOjosAzules();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		
		aSacrificar.add(monstruoC);
		aSacrificar.add(monstruoB);

		jugador.jugarCartaBocaAbajo(monstruoC);
		jugador.jugarCartaBocaAbajo(monstruoB);
		jugador.jugarCartaBocaAbajoSacrificando(monstruoA, aSacrificar);
		
		assert monstruoC.estaEnElCementerio();
		assert monstruoB.estaEnElCementerio();
	}

	@Test
	public void testo10ActivoEfectoJinzoYAtacoALosPuntosDeVidaDirectamente() throws ExcepcionAlGoOh {
		Jugador jugador = new Jugador();
		Jugador rival = new Jugador();
		rival.establecerOponente(jugador);
		jugador.establecerOponente(rival);

		Monstruo monstruo = new AgresorOscuro();
		
		Jinzo7 jinzo7 = new Jinzo7();

		rival.jugarCartaBocaAbajo(monstruo);
		jugador.jugarCartaBocaArriba(jinzo7);
		jinzo7.colocarEnAtaque();
		
		jugador.atacar(jinzo7, monstruo);
		
		assertEquals(7500,rival.obtenerPuntosDeVida(),DELTA);
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
	public void test13invocacionDragonDefinitivoDeOjosAzulesSacrifica3DragonesDeOjosAzules() throws ExcepcionAlGoOh{
		
		Jugador jugador = new Jugador();
		
		Monstruo aux1 = new AgresorOscuro(); //Se requieren monstruos para sacrificar para colocar Dragones
		Monstruo aux2 = new AgresorOscuro();
		Monstruo aux3 = new AgresorOscuro();
		Monstruo aux4 = new AgresorOscuro();
		Monstruo aux5 = new AgresorOscuro();
		Monstruo aux6 = new AgresorOscuro();
		
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		LinkedList<Monstruo> dragones = new LinkedList<>();
		
		Monstruo dragon1 = new DragonBlancoDeOjosAzules();
		Monstruo dragon2 = new DragonBlancoDeOjosAzules();
		Monstruo dragon3 = new DragonBlancoDeOjosAzules();
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
	
		dragones.add(dragon1);
		dragones.add(dragon2);
		dragones.add(dragon3);
		
		aSacrificar.clear();
		aSacrificar.add(aux1);
		aSacrificar.add(aux2);
		jugador.jugarCartaBocaAbajo(aux1);
		jugador.jugarCartaBocaAbajo(aux2);
		jugador.jugarCartaBocaAbajoSacrificando(dragon1, aSacrificar);
		
		
		aSacrificar.clear();
		aSacrificar.add(aux3);
		aSacrificar.add(aux4);
		jugador.jugarCartaBocaAbajo(aux3);
		jugador.jugarCartaBocaAbajo(aux4);
		jugador.jugarCartaBocaAbajoSacrificando(dragon2, aSacrificar);
		
		aSacrificar.clear();
		aSacrificar.add(aux5);
		aSacrificar.add(aux6);
		jugador.jugarCartaBocaAbajo(aux5);
		jugador.jugarCartaBocaAbajo(aux6);
		jugador.jugarCartaBocaAbajoSacrificando(dragon3, aSacrificar);

		jugador.jugarCartaBocaAbajoSacrificando(definitivo, dragones);

		assert dragon1.estaEnElCementerio();
		assert dragon2.estaEnElCementerio();
		assert dragon3.estaEnElCementerio();
	}
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void test14InvocarDragonDefinitivoSinTenerDragonesBlancosLanzaExcepcion() throws ExcepcionAlGoOh {
		
		Jugador jugador = new Jugador();
		
		Monstruo aux1 = new AgresorOscuro(); //Se requieren monstruos para sacrificar para colocar Dragones
		Monstruo aux2 = new AgresorOscuro();
		Monstruo aux3 = new AgresorOscuro();
		
		LinkedList<Monstruo> aSacrificar = new LinkedList<>(); //3 monstruos que no son dragones
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		aSacrificar.add(aux1);
		aSacrificar.add(aux2);
		aSacrificar.add(aux3);
		
		jugador.jugarCartaBocaAbajo(aux1);
		jugador.jugarCartaBocaAbajo(aux2);
		jugador.jugarCartaBocaAbajo(aux3);
		jugador.jugarCartaBocaAbajoSacrificando(definitivo, aSacrificar);
	}
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void test15InvocarDragonDefinitivoConMenosDe3DragonesBlancosLanzaExcepcion() throws ExcepcionAlGoOh {
		
		Jugador jugador = new Jugador();
		
		Monstruo aux1 = new AgresorOscuro();
		Monstruo aux2 = new AgresorOscuro();
		Monstruo aux3 = new AgresorOscuro();
		Monstruo aux4 = new AgresorOscuro();
 		Monstruo dragon = new DragonBlancoDeOjosAzules();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>(); //2 monstruos para agregar un dragon blanco
		LinkedList<Monstruo> dragones = new LinkedList<>(); //Menos de 3 dragones
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		
		dragones.add(dragon);
		dragones.add(dragon);
	
		aSacrificar.add(aux1);
		aSacrificar.add(aux2);
		jugador.jugarCartaBocaAbajo(aux1);
		jugador.jugarCartaBocaAbajo(aux2);
		jugador.jugarCartaBocaAbajoSacrificando(dragon, aSacrificar);
		
		aSacrificar.clear();
		aSacrificar.add(aux3);
		aSacrificar.add(aux4);
		jugador.jugarCartaBocaAbajo(aux3);
		jugador.jugarCartaBocaAbajo(aux4);
		jugador.jugarCartaBocaAbajoSacrificando(dragon, aSacrificar);
		
		jugador.jugarCartaBocaAbajoSacrificando(definitivo, aSacrificar);
	}
	
	@Test
	public void test16SiSeSeleccionanMasMonstruosQueLosNecesariosSeSacrificaranLosNecesariosYSeDestruiranLosDemas() throws ExcepcionAlGoOh {

		Jugador jugador = new Jugador();
		Monstruo dragon = new DragonBlancoDeOjosAzules();
		Monstruo monstruoA = new AgresorOscuro();
		Monstruo monstruoB = new AgresorOscuro();
		Monstruo monstruoC = new AgresorOscuro();

		jugador.jugarCartaBocaAbajo(monstruoA);
		jugador.jugarCartaBocaAbajo(monstruoB);
		jugador.jugarCartaBocaAbajo(monstruoC);
		
		LinkedList<Monstruo> todos = jugador.obtenerMonstruos();
		
		jugador.jugarCartaBocaAbajoSacrificando(dragon, todos);
		
		assert monstruoA.estaEnElCementerio();
		assert monstruoB.estaEnElCementerio();
		assert monstruoC.estaEnElCementerio();
	}
	
	@Test
	public void test17InsectoComeHombresRecibeAtaqueEstandoBocaAbajoActivaEfectoDeVolteoSenialandoAtacanteLoDestruyeYNadiePierdeVida() throws ExcepcionAlGoOh {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		
		AgresorOscuro monstruoAtacante = new AgresorOscuro();
		jugadorA.ponerEnAtaque(monstruoAtacante);
		jugadorA.jugarCartaBocaArriba(monstruoAtacante);
		
		InsectoComeHombres insecto = new InsectoComeHombres();
		jugadorB.jugarCartaBocaAbajo(insecto);

		insecto.aplicarEfecto(monstruoAtacante);
		
		assert monstruoAtacante.estaEnElCementerio();
		assertEquals(8000, jugadorA.obtenerPuntosDeVida(), DELTA);
		assertEquals(8000, jugadorB.obtenerPuntosDeVida(), DELTA);
	}
	
}
