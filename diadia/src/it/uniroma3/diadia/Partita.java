package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	
	private Labirinto lab;
	private Giocatore player;
	
	private boolean finita;
	
	
	public Partita(){
		//creaStanze();
		lab = new Labirinto();
		this.finita = false;
		player = new Giocatore("Bruno");
	}
	
	// i metodi set e get delle stanze vincenti e correnti 
	// richiamano quelli nella classe Labirinto, che li gestisce
	
	public Stanza getStanzaVincente() {
		return lab.getVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		lab.setCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return lab.getCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player.getCfu() == 0);
	}
	
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	// i metodi set e get dei cfu richiamano
	// quelli nella classe Labirinto, che li gestisce
	
	public int getCfu() {
		return player.getCfu();
	}

	public void setCfu(int cfu) {
		player.setCfu(cfu);		
	}
	
}
