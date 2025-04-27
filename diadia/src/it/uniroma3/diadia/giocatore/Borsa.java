package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella gli attrezzi nella borsa
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		System.out.println(this.toString());
		return true;
		
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
		a = attrezzi[i];
		
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
		}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa
	 * @param nomeAttrezzo
	 * @return l'attrezzo appena rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		
		if (nomeAttrezzo.equals(null)) return null;
		
		for(int i=0; i<this.numeroAttrezzi;i++) {
			if(this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a=this.attrezzi[i];
				for(int j=i;j<this.numeroAttrezzi-1;j++) {
					this.attrezzi[j]=this.attrezzi[j+1];
				}
				this.attrezzi[this.numeroAttrezzi-1] = null;
				this.numeroAttrezzi--;

				return a;
			}
		}
		return null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}