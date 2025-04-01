package it.uniroma3.diadia;

/**
 * Questa classe testa la classe Labirinto sui metodi:
 * creaStanze, isFinita
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Labirinto;

import org.junit.jupiter.api.BeforeEach;


class testLabirinto {

	Labirinto lab;
	
	@BeforeEach
	void setUp() {
		lab = new Labirinto();
	}
	
	
	//----------------TEST PER "CREA STANZE"----------------------------
	
		/**
		 * controlla che la stanza iniziale non sia nulla
		 */
		@Test
		void testCreaStanze_inizio() {
			assertNotNull(lab.getCorrente());
		}
		
		/**
		 * controlla che la stanza vincente non sia nulla
		 */
		@Test
		void testCreaStanze_fine() {
			assertNotNull(lab.getVincente());
		}
		
		/**
		 * controlla che la stanza finale sia la biblioteca
		 */
		@Test
		void testCreaStanze_biblioteca() {
			assertEquals("Biblioteca",lab.getVincente());
		}
}
