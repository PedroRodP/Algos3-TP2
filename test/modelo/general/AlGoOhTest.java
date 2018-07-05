package modelo.general;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.cartas.Carta;
import main.java.cartas.campo.Campo;
import main.java.cartas.campo.campos.Wasteland;
import main.java.cartas.magica.Magica;
import main.java.cartas.magica.magicas.Fisura;
import main.java.cartas.monstruo.Monstruo;
import main.java.cartas.monstruo.monstruos.AgresorOscuro;
import main.java.cartas.monstruo.monstruos.exodia.BrazoDerechoExodia;
import main.java.cartas.monstruo.monstruos.exodia.BrazoIzquierdoExodia;
import main.java.cartas.monstruo.monstruos.exodia.CabezaExodia;
import main.java.cartas.monstruo.monstruos.exodia.PiernaDerechaExodia;
import main.java.cartas.monstruo.monstruos.exodia.PiernaIzquierdaExodia;
import main.java.excepciones.ExcepcionCartaBocaAbajo;
import main.java.excepciones.ExcepcionFaseIncorrecta;
import main.java.excepciones.ExcepcionJuegoNoTermino;
import main.java.excepciones.ExcepcionJuegoTerminado;
import main.java.excepciones.ExcepcionMazoVacio;
import main.java.excepciones.ExcepcionMonstruoNoPuedeAtacar;
import main.java.excepciones.ExcepcionMonstruoYaAtaco;
import main.java.excepciones.ExcepcionSacrificiosInsuficientes;
import main.java.excepciones.ExcepcionTurnoFinalizo;
import main.java.excepciones.ExcepcionZonaCompleta;
import main.java.excepciones.ExcepcionZonaIncorrecta;
import main.java.general.AlGoOh;
import main.java.general.Jugador;
import main.java.general.Mano;

public class AlGoOhTest {
	
	@Test
	public void test01SiNoHayCartasEnMazoJugadorPierde() throws ExcepcionJuegoNoTermino {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.turnoActual();
		
		for (int i = 0; i <= 40; i++) { //41 veces, se acaba el mazo
			jugador.tomarCartaDelMazo();
		}
		
		assertEquals(jugador, juego.ganador().obtenerOponente());
		
	}
	
	@Test
	(expected = ExcepcionJuegoTerminado.class)
	public void test02SiNoHayCartasEnMazoJuegoTermina() throws ExcepcionJuegoTerminado, ExcepcionTurnoFinalizo {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.turnoActual();
		
		for (int i = 0; i <= 40; i++) {
			jugador.tomarCartaDelMazo();
		}
		
		//Intenta seguir jugando
		juego.pasarASiguienteFase();
	}
	
	@Test
	(expected = ExcepcionFaseIncorrecta.class)
	public void test03JugadorPuedeJugarCartaBocaArribaEnLaSegundaFaseYNoAtacarEnLaMismaFase() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta, ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.turnoActual();
		Monstruo ag = new AgresorOscuro();
		Monstruo def = new AgresorOscuro();
		
		juego.jugarCartaBocaArriba(ag);
		juego.colocarEnAtaque(ag);
		jugador.obtenerOponente().jugarCartaBocaAbajo(def);
		
		juego.atacarCon(ag, def);
	}
	
	@Test
	public void test04JugadorAtacaEnLaTerceraFaseYGanaPorEfectoDeCampo() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado, ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta, ExcepcionFaseIncorrecta, ExcepcionMonstruoNoPuedeAtacar, ExcepcionCartaBocaAbajo, ExcepcionMonstruoYaAtaco {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.turnoActual();
		Monstruo ata = new AgresorOscuro(); //+200 ataque por campo
		Monstruo def = new AgresorOscuro(); //+300 defensa por campo
		Campo sogen = new Wasteland();
		
		juego.jugarCartaBocaArriba(ata);
		juego.colocarEnAtaque(ata);
		juego.jugarCartaBocaArriba(sogen); 	//Crea diferenciaDeCombate = 100 entre los AgresorOscuro,
											//en contra de Jugador turnoActual
		jugador.obtenerOponente().jugarCartaBocaAbajo(def); //Oponente juega su monstruo en defensa y boca abajo
		
		juego.pasarASiguienteFase();
		
		juego.atacarCon(ata, def); //Sogen modifica ataque 
		
		assertEquals(8000 - 100, jugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void test05JugadorAplicaMagicaEnLaCuartaFaseYDestruyeMonstruoOponente() throws ExcepcionZonaCompleta, ExcepcionSacrificiosInsuficientes, ExcepcionZonaIncorrecta, ExcepcionFaseIncorrecta, ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado, ExcepcionCartaBocaAbajo, ExcepcionMazoVacio {
		
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.turnoActual();
		Magica fisura = new Fisura();
		Monstruo def = new AgresorOscuro();
		
		juego.jugarCartaBocaArriba(fisura);
		jugador.obtenerOponente().jugarCartaBocaAbajo(def); //Deberia jugarlo en su turno
		
		juego.pasarASiguienteFase();
		juego.pasarASiguienteFase();
		
		juego.aplicarMagica(fisura);
		
		assert(def.estaEnElCementerio());
	}

	@Test
	(expected = ExcepcionTurnoFinalizo.class)
	public void test06SiSePasaASiguienteFaseYNoHayMasArrojaExcepcionTurnoFinalizo() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado {
		
		AlGoOh juego = new AlGoOh();
		
		//Solo hay 3 fases. El ultimo llamado no devolvera una fase.
		juego.pasarASiguienteFase();
		juego.pasarASiguienteFase();
		juego.pasarASiguienteFase();
	}
	
	@Test
	(expected = ExcepcionJuegoTerminado.class)
	public void test18SiTengoTodasLasPartesDeExodiaEnLaManoYJugadorIntentaPasarDeFaseLanzaExcepcionJuegoTerminado() throws ExcepcionTurnoFinalizo, ExcepcionJuegoTerminado {
		AlGoOh juego = new AlGoOh();
		Jugador jugador = juego.turnoActual();
		Mano mano = jugador.obtenerMano();
		Carta brazoDer = new BrazoDerechoExodia();
		Carta brazoIzq = new BrazoIzquierdoExodia();
		Carta cabeza = new CabezaExodia();
		Carta piernaDer = new PiernaDerechaExodia();
		Carta piernaIzq = new PiernaIzquierdaExodia();
		mano.agregar(brazoDer); mano.agregar(brazoIzq); mano.agregar(cabeza); mano.agregar(piernaDer); mano.agregar(piernaIzq);
		jugador.comprobarExodia();
		juego.pasarASiguienteFase();
		
	}
	
}
