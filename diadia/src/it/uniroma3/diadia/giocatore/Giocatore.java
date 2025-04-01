package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

//TODO fare classe test 

/**
 * Questa classe gestisce i cfu del giocatore durante la partita
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

public class Giocatore {
	
	
	static final private int CFU_INIZIALI = 20;	
	private int cfu;
	private String nome;
	
	private Borsa borsa;
	
	public Giocatore(String nome) {
		this.nome= nome;
		this.cfu=CFU_INIZIALI;
		borsa = new Borsa();
	}
	
	// aggiunge un attrezzo e lo memorizza nella borsa
	
	public boolean aggiungiAttrezzo(Attrezzo attrezzo) {
		return borsa.addAttrezzo(attrezzo);
	}
	
	// gestione dei cfu
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}

	// get nome
	
	public String getNome() {
		return nome;
	}	
	
}
