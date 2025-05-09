package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Comando "Posa", prende un oggetto dalla borsa e lo 
 * posa nella stanza.
 */

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		Scanner scanner = new Scanner(System.in);
		Attrezzo attrezzo;
		if(nomeAttrezzo==null) {
			System.out.println("Scegli l'attrezzo che vuoi posare: ");
			System.out.println(partita.getGiocatore().getBorsa().toString());  
			nomeAttrezzo = scanner.nextLine();
		}
		if(nomeAttrezzo==null) 
			System.out.println("Prima scegli l'attrezzo che vuoi posare.");
		
		else if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			attrezzo = new Attrezzo(nomeAttrezzo,partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo).getPeso());
			
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			System.out.println("Hai posato l'attrezzo.");		

		}
		else 
			System.out.println("Quell'attrezzo non è nella tua borsa... ");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}

}
