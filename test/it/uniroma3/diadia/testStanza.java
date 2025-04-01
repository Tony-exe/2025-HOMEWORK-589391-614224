package it.uniroma3.diadia;

/**
 * Questa classe testa la classe Stanza sui metodi:
 * impostaStanzaAdiacente, addAttrezzo, getAttrezzo
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;

class testStanza {
	
	private Stanza stanza;
	private Stanza stanzaAdiac;
	private Attrezzo attrezzo;
	
	
	/**
	 * metodo di setUp che inizializza gli oggetti di test
	 */
	@BeforeEach
	void setUp() {
		stanza = new Stanza("Biblioteca");
		stanzaAdiac = new Stanza("Corridoio");
		attrezzo = new Attrezzo("Lanterna",3);
	}
	
	
	//---------------TEST PER "IMPOSTA STANZA ADIACENTE"---------------
	
	/**
	 * controlla che la stanza adiacente sia settata e sia giusta
	 */
	@Test
	void testImpostaStanzaAdiacente() {
		stanza.impostaStanzaAdiacente("nord",stanzaAdiac);
		assertEquals(stanzaAdiac,stanza.getStanzaAdiacente("nord"));
	}
	
	/**
	 * controlla che la stanza adiacente "sovrascriva" correttamente
	 * un altra stanza adiacente già posizionata in quella direzione
	 */
	@Test
	void testImpostaStanzaAdiacente_sovrascriviStanza() {
		stanza.impostaStanzaAdiacente("nord", stanzaAdiac);
		Stanza newStanza = new Stanza("Atrio");
		stanza.impostaStanzaAdiacente("nord", newStanza);
		assertEquals(newStanza,stanza.getStanzaAdiacente("nord"));
	}
	
	/**
	 * controlla che una stanza abbia stanze adiacenti solo
	 * nelle direzioni giuste (nord, sud, est, ovest)
	 */
	@Test
	void testImpostaStanzaAdiacente_direzioniCorrette() {
		stanza.impostaStanzaAdiacente("nord", stanzaAdiac);
		stanza.impostaStanzaAdiacente("sud", new Stanza("Cucina"));
		stanza.impostaStanzaAdiacente("est", new Stanza("Atrio"));
		stanza.impostaStanzaAdiacente("ovest", new Stanza("Laboratorio"));
		
		stanza.impostaStanzaAdiacente("sudest", new Stanza("Aula 12"));
		assertNull(stanza.getStanzaAdiacente("sudest"));
	}
	
	
	//----------------TEST PER "ADD ATTREZZO"---------------------------
	
	/**
	 * controlla che la fnzione addAttrezzo ritorni Vero
	 * cioè che l'oggetto è stato aggiunto alla stanza
	 */
	@Test
	void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(attrezzo));
	}
	
	/**
	 * controlla che non ci siano piu di 10 attrezzi
	 * che è il numero di attrezzi max che possono stare in
	 * una stanza
	 */
	@Test
	void testAddAttrezzo_max() {
		for(int i=0;i<10;i++) {
			stanza.addAttrezzo(new Attrezzo("Attrezzo"+i,1));
		}
		assertFalse(stanza.addAttrezzo(new Attrezzo("Attrezzo 11",1)));
	}
	
	/**
	 * controlla che l'attrezzo Lanterna sia stato davvero inserito
	 */
	@Test
	void testAddAttrezzo_inserito() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("Lanterna"));
	}
	
	
	//--------------------TEST PER "GET ATTREZZO"-----------------------
	
	/**
	 * controlla che l'attrezzo inserito venga restituito
	 */
	@Test
	void testGetAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(attrezzo,stanza.getAttrezzo("Lanterna"));
	}
	
	/**
	 * controlla che cercando un attrezzo che non esiste
	 * restituisce null
	 */
	@Test
	void testGetAttrezzo_null() {
		assertNull(stanza.getAttrezzo("Accendino"));
	}
	
	
	
	
}
