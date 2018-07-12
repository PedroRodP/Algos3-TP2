package main.java.cartas;

import main.java.cartas.monstruo.monstruos.*;
import main.java.cartas.magica.magicas.*;

import java.util.LinkedList;

import main.java.cartas.campo.campos.*;
import main.java.cartas.trampa.trampas.*;

public class FabricaDeCartas {
	
	private Carta cartaRandom(LinkedList<Carta> cartas) {
	   int rango = (int)(Math.random() * cartas.size());
	   return cartas.get(rango);
	}
	
	
	public Carta obtenerMonstruoAleatorio() {
		LinkedList<Carta> monstruos = new LinkedList<Carta>();
		monstruos.add(new AbismoReluciente());
		monstruos.add(new AgresorOscuro());
		monstruos.add(new AgujaAsesina());
		monstruos.add(new Aitsu());
		monstruos.add(new AlcanzadorDeGarra());
		monstruos.add(new AmanteFeliz());
		monstruos.add(new Ansatsu());
		monstruos.add(new AntiguoDeLasProfundidades());
		monstruos.add(new AraniaLanzadora());
		monstruos.add(new AsesinoDeLaEspada());
		monstruos.add(new BestiaAmfibia());
		monstruos.add(new BestiaDeTalwar());
		monstruos.add(new BrujaOscura());
		monstruos.add(new DragonBlancoDeOjosAzules());
		monstruos.add(new DragonDefinitivoDeOjosAzules());
		monstruos.add(new Jinzo7());
		monstruos.add(new InsectoComeHombres());
		monstruos.add(new BrazoDerechoExodia());
		monstruos.add(new BrazoIzquierdoExodia());
		monstruos.add(new CabezaExodia());
		monstruos.add(new PiernaDerechaExodia());
		monstruos.add(new PiernaIzquierdaExodia());
		return cartaRandom(monstruos);
	}
	
	
	
	public Carta obtenerMagicaAleatoria() {
		LinkedList<Carta> magicas = new LinkedList<Carta>();
		magicas.add(new AgujeroNegro());
		magicas.add(new Fisura());
		magicas.add(new OllaDeLaCodicia());
		return cartaRandom(magicas);
	}
	
	public Carta obtenerTrampaAleatoria() {
		LinkedList<Carta> trampas = new LinkedList<Carta>();
		trampas.add(new CilindroMagico());
		trampas.add(new Reinforcements());
		return cartaRandom(trampas);
	}
	
	public Carta obtenerCampoAleatorio() {
		LinkedList<Carta> campos = new LinkedList<Carta>();
		campos.add(new Wasteland());
		campos.add(new Sogen());
		return cartaRandom(campos);
	}
	
}
