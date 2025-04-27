package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Comando "Prendi", prende un oggetto che è stato
 * trovato nella stanza.
 */

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getNumeroAttrezzi()!=0) {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);  	//QUESTO È IL PROBLEMA. ATTREZZO VALE SEMPRE NULL 
				
			if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) { 
				if(partita.getGiocatore().aggiungiAttrezzo(attrezzo) && stanzaCorrente.removeAttrezzo(attrezzo))
					System.out.println("Hai preso "+ nomeAttrezzo +" e l'hai messo nella borsa!");
				else
					System.out.println("Non sei riuscito a prendere l'attrezzo.");
			}
			else {
				System.out.println("Questo attrezzo non c'è qui!");
				}
		}	
		else if(partita.getStanzaCorrente().getNumeroAttrezzi()==0){
			System.out.println("\nNon c'è nulla da prendere qui!\n");
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

}
