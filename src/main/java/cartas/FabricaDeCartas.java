package main.java.cartas;

import main.java.cartas.monstruo.monstruos.*;
import main.java.cartas.monstruo.monstruos.exodia.*;
import main.java.cartas.magica.magicas.*;

import java.util.LinkedList;

import main.java.cartas.campo.campos.*;
import main.java.cartas.trampa.trampas.*;

public class FabricaDeCartas {
	
	private LinkedList<Carta> cartas;
	private int i; //Es el indice de la lista y representa la cantidad de cartas en la lista tambien
	
	public FabricaDeCartas() {
		
		cartas = new LinkedList<Carta>();
	}
	
	public Carta obtenerCarta(int pos) {
		return cartas.get(pos);
	}
	
	public int cantidadDeCartas() {
		return i;
	}
	
	public void generarMonstruos() {
		
		i = 0;
		
		cartas.add(i++, new AbismoReluciente());
		cartas.add(i++, new AgresorOscuro());
		cartas.add(i++, new AgujaAsesina());
		cartas.add(i++, new Aitsu());
		cartas.add(i++, new AlcanzadorDeGarra());
		cartas.add(i++, new AmanteFeliz());
		cartas.add(i++, new Ansatsu());
		cartas.add(i++, new AntiguoDeLasProfundidades());
		cartas.add(i++, new AraniaLanzadora());
		cartas.add(i++, new AsesinoDeLaEspada());
		cartas.add(i++, new BestiaAmfibia());
		cartas.add(i++, new BestiaDeTalwar());
		cartas.add(i++, new BrujaOscura());
		cartas.add(i++, new DragonBlancoDeOjosAzules());
		cartas.add(i++, new DragonDefinitivoDeOjosAzules());
		cartas.add(i++, new Jinzo7());
		cartas.add(i++, new InsectoComeHombres());
		cartas.add(i++, new BrazoDerechoExodia());
		cartas.add(i++, new BrazoIzquierdoExodia());
		cartas.add(i++, new CabezaExodia());
		cartas.add(i++, new PiernaDerechaExodia());
		cartas.add(i++, new PiernaIzquierdaExodia());
	}
	
	public void generarMagicas() {
		
		i = 0;
		
		cartas.add(i++, new AgujeroNegro());
		cartas.add(i++, new Fisura());
		cartas.add(i++, new OllaDeLaCodicia());
	}
	
	public void generarTrampas() {
		
		i = 0;
		
		cartas.add(i++, new CilindroMagico());
		cartas.add(i++, new Reinforcements());
	}
	
	public void generarCampos() {
		
		i = 0;
		
		cartas.add(i++, new Wasteland());
		cartas.add(i++, new Sogen());
	}
	
}
