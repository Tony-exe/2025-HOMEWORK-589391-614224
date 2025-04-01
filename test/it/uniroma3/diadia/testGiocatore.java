package it.uniroma3.diadia;
/**
 * Questa classe testa la classe giocatore
 * @author  Diana
 * @see Stanza
 * @version base
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Attrezzo;
import it.uniroma3.diadia.Borsa;
import it.uniroma3.diadia.Giocatore;

import org.junit.jupiter.api.BeforeEach;

class testGiocatore {

	Giocatore player;
	Borsa borsa;
	
	@BeforeEach
	void setUp() {
		player = new Giocatore("Bruno");
		borsa = new Borsa();
	}
	
	//------------ TEST PER "AGGIUNGI ATTREZZO"----------
	
	/**
	 * controlla che l'oggetto venga aggiunto correttametne
	 */
	@Test
	void testAggiungiAttrezzo() {
		assertTrue(player.aggiungiAttrezzo(new Attrezzo("Lanterna",3)));
	}
	
	//------------ TEST PER "SET E GET CFU"----------
	
	/**
	 * controlla che i cfu restituiti siano corretti
	 */
	@Test
	void testCfu() {
		player.setCfu(10);
		assertEquals(10,player.getCfu());
	}
	
	//------------ TEST PER "GET NOME"----------
	
	/**
	 * controlla che il nome sia giusto
	 */
	@Test
	void testNome() {
		assertEquals("Bruno",player.getNome());
	}
}
