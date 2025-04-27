package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private IOConsole interazione;
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
		this.interazione = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		
	
		interazione.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = interazione.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if(this.partita.vinta()) 
			interazione.mostraMessaggio("Hai vinto!");
		return this.partita.isFinita();
	}   
	
	/**
	 * Comando "Prendi", prende un oggetto che è stato
	 * trovato nella stanza.
	 */
	private void prendi(String nomeAttrezzo) {
		if(this.partita.getStanzaCorrente().getNumeroAttrezzi()!=0) {
			Stanza stanzaCorrente = this.partita.getStanzaCorrente();
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);  	//QUESTO È IL PROBLEMA. ATTREZZO VALE SEMPRE NULL 
				
			if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) { 
				if(this.partita.getGiocatore().aggiungiAttrezzo(attrezzo) && stanzaCorrente.removeAttrezzo(attrezzo))
					interazione.mostraMessaggio("Hai preso "+ nomeAttrezzo +" e l'hai messo nella borsa!");
				else
					interazione.mostraMessaggio("Non sei riuscito a prendere l'attrezzo.");
			}
			else {
					interazione.mostraMessaggio("Questo attrezzo non c'è qui!");
				}
		}	
		else if(this.partita.getStanzaCorrente().getNumeroAttrezzi()==0){
			System.out.println("\nNon c'è nulla da prendere qui!\n");
		}
	}
	
	
	/**
	 * Comando "Posa", prende un oggetto dalla borsa e lo 
	 * posa nella stanza.
	 */
	private void posa() {
		String nomeAttrezzo;
		Scanner scanner = new Scanner(System.in);
		Attrezzo attrezzo;
		
		System.out.println("Scegli l'attrezzo che vuoi posare: ");
		System.out.println(this.partita.getGiocatore().getBorsa().toString());  
		nomeAttrezzo = scanner.nextLine();
		
		if(nomeAttrezzo==null) 
			System.out.println("Prima scegli l'attrezzo che vuoi posare.");
		
		else if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			attrezzo = new Attrezzo(nomeAttrezzo,this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo).getPeso());
			
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			System.out.println("Hai posato l'attrezzo.");		

		}
		else 
			System.out.println("Quell'attrezzo non è nella tua borsa... ");		
	}
	
	public static void main(String[] argc) {
		//IOConsole interazione = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}