package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

// TODO fare classe test per creaStanze,getCorrente e getVincente

/**
 * Questa classe modella il labirinto
 *
 * @author 	Diana
 * @see Partita,Stanza
 * @version base
 */


public class Labirinto {

	public Stanza stanzaCorrente;
	public Stanza stanzaVincente;
	
	public Labirinto() {
		this.creaStanze();
	}
	
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
	private void creaStanze() {
		
		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo pass = new Attrezzo("pass", 1);
		Attrezzo computer = new Attrezzo("computer", 5);
		Attrezzo matita = new Attrezzo("matita", 1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza bagno = new StanzaMagica("Bagno");
		Stanza sgabuzzino = new StanzaBuia("Sgabuzzino", "lanterna");
		Stanza aulaN12 = new StanzaBloccata("Aula N12", "est", "pass"); 
		Stanza aulaN13 = new Stanza("Aula N13"); //stanza bloccata passando da Aula N12
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", sgabuzzino);
		aulaN11.impostaStanzaAdiacente("sud", aulaN12);
		
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN12);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		
		aulaN12.impostaStanzaAdiacente("ovest", aulaN10); //Stanza bloccata
		aulaN12.impostaStanzaAdiacente("nord", aulaN11);
		aulaN12.impostaStanzaAdiacente("est", aulaN13); //Direzione bloccata
		
		aulaN13.impostaStanzaAdiacente("ovest", aulaN12);
		
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("nord", bagno);
		
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
		bagno.impostaStanzaAdiacente("est", biblioteca); //Stanza magica
		bagno.impostaStanzaAdiacente("sud", laboratorio);
		
		sgabuzzino.impostaStanzaAdiacente("sud", aulaN11); //Stanza buia
		sgabuzzino.impostaStanzaAdiacente("ovest", biblioteca);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		aulaN11.addAttrezzo(osso);
		atrio.addAttrezzo(pass);
		laboratorio.addAttrezzo(computer);
		sgabuzzino.addAttrezzo(matita);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
		
	}
	
	//getter e setter che vengono richiamati nella classe partita
	
	public Stanza getCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getVincente() {
		return stanzaVincente;
	}

	public void setCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
}
