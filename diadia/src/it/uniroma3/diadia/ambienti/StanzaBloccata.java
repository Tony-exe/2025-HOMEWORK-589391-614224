package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String oggettoSbloccante;
	
	public StanzaBloccata(String nome, String dir, String unlock) {
		super(nome);
		direzioneBloccata = dir;
		oggettoSbloccante = unlock;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione, Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		if(!stanzaCorrente.hasAttrezzo(this.oggettoSbloccante) && direzione.equals(this.direzioneBloccata)) {
			System.out.println("La direzione è bloccata! Serve: " + this.oggettoSbloccante); 
			return this;
		}
		else {
			return super.getStanzaAdiacente(direzione, partita);
		}
			
	}
}
