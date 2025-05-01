package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.giocatore.Giocatore;

public class StanzaBuia extends Stanza {
	private String oggettoLuminoso;
	
	public StanzaBuia(String nome, String oggetto) {
		super(nome);
		oggettoLuminoso = oggetto;
	}
	
	/**
	 * Modifica la descrizione della stanza
	 * 
	 * @return "Qui c'è buio pesto" se il giocatore non possiede l'oggetto luminoso nella borsa
	 * la descrizione normale se questo giocatore invece ha l'oggetto richiesto
	 * 
	 */
	
	@Override
	public String getDescrizione(Giocatore giocatore) {
		if(!giocatore.getBorsa().hasAttrezzo(this.oggettoLuminoso)) {
			String buio = "Qui c'è buio pesto";
			return buio;
		}
		return super.getDescrizione(giocatore);
	}

}
