package it.uniroma3.diadia;

/**
 * Questa classe testa la classe Partita sui metodi:
 * creaStanze, isFinita
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

import org.junit.jupiter.api.BeforeEach;

class testPartita {
	
	Partita partita;

	/**
	 * metodo di setUp che inizializza gli oggetti di test
	 */
	@BeforeEach
	void setUp() {
		partita = new Partita();
	}
	
	//----------------TEST PER "CREA STANZE"----------------------------
	// (non piu necessari dopo che il metodo "creaStanze" è stato
	//  "spostato" nella classe Labirinto)
	
	/**
	 * controlla che la stanza iniziale non sia nulla
	 */
	@Test
	void testCreaStanze_inizio() {
		assertNotNull(partita.getStanzaCorrente());
	}
	
	/**
	 * controlla che la stanza vincente non sia nulla
	 */
	@Test
	void testCreaStanze_fine() {
		assertNotNull(partita.getStanzaVincente());
	}
	
	/**
	 * controlla che la stanza finale sia la biblioteca
	 */
	@Test
	void testCreaStanze_biblioteca() {
		assertEquals("Biblioteca",partita.getStanzaVincente());
	}
	
	//----------------TEST PER "IS FINITA"----------------------------------
	
	/**
	 * controlla che la partita sia inizialmente non finita
	 */
	@Test
	void testIsFinita_inizio() {
		assertFalse(partita.isFinita());
	}
	
	/**
	 * controlla che la partita finisca tramite i cfu
	 */
	@Test
	void testIsFinita_cfu() {
		partita.setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	/**
	 * controlla che la partita finisca perche abbiamo settato Finita
	 */
	@Test
	void testIsFinita_set() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
}
