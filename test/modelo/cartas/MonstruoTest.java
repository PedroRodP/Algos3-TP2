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
	public void test03MonstruoEnAtaqueMuereSiAtacaAMonstruoConMayorAtaqueEnModoAtaque()
			throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		jugador.establecerOponente(new Jugador());
		
		Monstruo agresorOscuro = new AgresorOscuro();
		agresorOscuro.colocarEnAtaque();
		Monstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		dragonBlancoDeOjosAzules.colocarEnAtaque();
		
		jugador.jugarMonstruoBocaArriba(agresorOscuro);
		jugador.atacar(agresorOscuro,dragonBlancoDeOjosAzules);
		
		assertEquals(8000 - 1800,jugador.obtenerPuntosDeVida(),DELTA);
		assert (agresorOscuro.estaEnElCementerio());
	}
	
	@Test
	public void test04MonstruoEnAtaqueAtacaAMonstruoConMenorAtaqueYEsteMuere()
			throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		jugadorA.establecerOponente(jugadorB);
		
		Monstruo monstruoAzul = new AgresorOscuro();
		monstruoAzul.colocarEnAtaque();
		Monstruo monstruoVerde = new AmanteFeliz();
		monstruoVerde.colocarEnAtaque();

		jugadorB.jugarMonstruoBocaAbajo(monstruoVerde);
		jugadorA.jugarMonstruoBocaArriba(monstruoAzul);
		jugadorA.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(8000 - 400,jugadorB.obtenerPuntosDeVida(),DELTA);
		assert (monstruoVerde.estaEnElCementerio());
	}
	
	@Test
	public void test05MonstruoEnAtaqueAtacaAMonstruoConIgualAtaqueYAmbosSeDestruyenPeroNoInfligenDanio()
			throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoA = new AmanteFeliz();
		Monstruo monstruoB = new AmanteFeliz();

		oponente.jugarMonstruoBocaAbajo(monstruoB);
		atacante.establecerOponente(oponente);
		atacante.jugarMonstruoBocaArriba(monstruoA);
		
		monstruoA.colocarEnAtaque();
		monstruoB.colocarEnAtaque();
		
		atacante.atacar(monstruoA,monstruoB);
		
		assertEquals(8000, atacante.obtenerPuntosDeVida(), DELTA);
		assertEquals(8000, oponente.obtenerPuntosDeVida(), DELTA);
		
		assert (monstruoA.estaEnElCementerio());
		assert (monstruoB.estaEnElCementerio());
	}

	@Test
	public void test06MonstruoEnAtaqueAtacaAMonstruoConMenorDefensaYSeDestruyeSinInfligirDanio()
			throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		
		Monstruo monstruoA = new AgresorOscuro();
		Monstruo monstruoB = new AmanteFeliz();
		
		atacante.establecerOponente(oponente);
		atacante.jugarMonstruoBocaArriba(monstruoA);
		atacante.jugarMonstruoBocaArriba(monstruoB);

		monstruoA.colocarEnAtaque();
		monstruoB.colocarEnDefensa();
		
		atacante.atacar(monstruoA, monstruoB);
		
		assertEquals(8000, oponente.obtenerPuntosDeVida(), DELTA);
		assert (monstruoB.estaEnElCementerio());
	}
	
	@Test
	public void test07MonstruoEnAtaqueAtacaAMonstruoConMayorDefensaYNoSeDestruyeNiInfligeDanio()
			throws ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador atacante = new Jugador();
		Jugador oponente = new Jugador();
		double vidaPreviaOponente = oponente.obtenerPuntosDeVida();
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoVerde = new AbismoReluciente();

		oponente.jugarMonstruoBocaAbajo(monstruoVerde);
		atacante.establecerOponente(oponente);
		atacante.jugarMonstruoBocaArriba(monstruoAzul);
		
		monstruoAzul.colocarEnAtaque();
		monstruoVerde.colocarEnDefensa();
		
		atacante.atacar(monstruoAzul, monstruoVerde);
		
		assertEquals(vidaPreviaOponente, oponente.obtenerPuntosDeVida(), DELTA);
		assert ! monstruoVerde.estaEnElCementerio();
	}
	
	@Test
	public void test08InvocacionAMonstruoDe5EstrellasSacrificaAMonstruoEnTablero()
			throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		Monstruo monstruoAzul = new AgresorOscuro();
		Monstruo monstruoRojo = new Aitsu();
		LinkedList<Monstruo> aSacrificar = new LinkedList<>();
		
		aSacrificar.add(monstruoAzul);
		
		jugador.jugarMonstruoBocaAbajo(monstruoAzul);
		jugador.jugarMonstruoBocaAbajoSacrificando(monstruoRojo, aSacrificar);
		
		assert monstruoAzul.estaEnElCementerio();
		
	}
	
	@Test
	public void test09InvocacionAMonstruoDe8EstrellasSacrificaAMonstruoEnTablero()
			throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
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
		
		assert monstruoRojo.estaEnElCementerio();
		assert monstruoVerde.estaEnElCementerio();
	}

	@Test
	public void testo10ActivoEfectoJinzoYAtacoALosPuntosDeVidaDirectamente()
			throws ExcepcionCartaBocaAbajo, ExcepcionMonstruoNoPuedeAtacar, ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		Jugador jugador = new Jugador();
		Jugador rival = new Jugador();
		rival.establecerOponente(jugador);
		jugador.establecerOponente(rival);

		Monstruo monstruo = new AgresorOscuro();
		
		Jinzo7 jinzo7 = new Jinzo7();

		rival.jugarMonstruoBocaAbajo(monstruo);
		jugador.jugarMonstruoBocaArriba(jinzo7);
		jinzo7.colocarEnAtaque();
		
		jinzo7.aplicarEfecto(rival);
		
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
	public void test13invocacionDragonDefinitivoDeOjosAzulesSacrifica3DragonesDeOjosAzules()
			throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta{
		
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
		jugador.jugarMonstruoBocaAbajo(aux1);
		jugador.jugarMonstruoBocaAbajo(aux2);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon1, aSacrificar);
		
		
		aSacrificar.clear();
		aSacrificar.add(aux3);
		aSacrificar.add(aux4);
		jugador.jugarMonstruoBocaAbajo(aux3);
		jugador.jugarMonstruoBocaAbajo(aux4);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon2, aSacrificar);
		
		aSacrificar.clear();
		aSacrificar.add(aux5);
		aSacrificar.add(aux6);
		jugador.jugarMonstruoBocaAbajo(aux5);
		jugador.jugarMonstruoBocaAbajo(aux6);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon3, aSacrificar);

		jugador.jugarMonstruoBocaAbajoSacrificando(definitivo, dragones);

		assert dragon1.estaEnElCementerio();
		assert dragon2.estaEnElCementerio();
		assert dragon3.estaEnElCementerio();
	}
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void test14InvocarDragonDefinitivoSinTenerDragonesBlancosLanzaExcepcion()
			throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
		Jugador jugador = new Jugador();
		
		Monstruo aux1 = new AgresorOscuro(); //Se requieren monstruos para sacrificar para colocar Dragones
		Monstruo aux2 = new AgresorOscuro();
		Monstruo aux3 = new AgresorOscuro();
		
		LinkedList<Monstruo> aSacrificar = new LinkedList<>(); //3 monstruos que no son dragones
		Monstruo definitivo = new DragonDefinitivoDeOjosAzules();
		
		aSacrificar.add(aux1);
		aSacrificar.add(aux2);
		aSacrificar.add(aux3);
		
		jugador.jugarMonstruoBocaAbajo(aux1);
		jugador.jugarMonstruoBocaAbajo(aux2);
		jugador.jugarMonstruoBocaAbajo(aux3);
		jugador.jugarMonstruoBocaAbajoSacrificando(definitivo, aSacrificar);
	}
	
	@Test
	(expected = ExcepcionSacrificiosInsuficientes.class)
	public void test15InvocarDragonDefinitivoConMenosDe3DragonesBlancosLanzaExcepcion() throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {
		
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
		jugador.jugarMonstruoBocaAbajo(aux1);
		jugador.jugarMonstruoBocaAbajo(aux2);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon, aSacrificar);
		
		aSacrificar.clear();
		aSacrificar.add(aux3);
		aSacrificar.add(aux4);
		jugador.jugarMonstruoBocaAbajo(aux3);
		jugador.jugarMonstruoBocaAbajo(aux4);
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon, aSacrificar);
		
		jugador.jugarMonstruoBocaAbajoSacrificando(definitivo, aSacrificar);
	}
	
	@Test
	public void test16SiSeSeleccionanMasMonstruosQueLosNecesariosSeSacrificaranLosNecesariosYSeDestruiranLosDemas() 
			throws ExcepcionSacrificiosInsuficientes, ExcepcionZonaCompleta {

		Jugador jugador = new Jugador();
		Monstruo dragon = new DragonBlancoDeOjosAzules();
		Monstruo monstruoA = new AgresorOscuro();
		Monstruo monstruoB = new AgresorOscuro();
		Monstruo monstruoC = new AgresorOscuro();

		jugador.jugarMonstruoBocaAbajo(monstruoA);
		jugador.jugarMonstruoBocaAbajo(monstruoB);
		jugador.jugarMonstruoBocaAbajo(monstruoC);
		
		LinkedList<Monstruo> todos = jugador.obtenerMonstruos();
		
		jugador.jugarMonstruoBocaAbajoSacrificando(dragon, todos);
		
		assert monstruoA.estaEnElCementerio();
		assert monstruoB.estaEnElCementerio();
		assert monstruoC.estaEnElCementerio();
	}
	
	@Test
	public void test17InsectoComeHombresRecibeAtaqueEstandoBocaAbajoActivaEfectoDeVolteoSenialandoAtacanteLoDestruyeYNadiePierdeVida()
			throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo {
		
		Jugador jugadorA = new Jugador();
		Jugador jugadorB = new Jugador();
		
		AgresorOscuro monstruoAtacante = new AgresorOscuro();
		jugadorA.ponerEnAtaque(monstruoAtacante);
		jugadorA.jugarMonstruoBocaArriba(monstruoAtacante);
		
		InsectoComeHombres insecto = new InsectoComeHombres();
		jugadorB.jugarMonstruoBocaAbajo(insecto);

		insecto.aplicarEfecto(monstruoAtacante);
		
		assert monstruoAtacante.estaEnElCementerio();
		assertEquals(8000, jugadorA.obtenerPuntosDeVida(), DELTA);
		assertEquals(8000, jugadorB.obtenerPuntosDeVida(), DELTA);
	}
	
}
