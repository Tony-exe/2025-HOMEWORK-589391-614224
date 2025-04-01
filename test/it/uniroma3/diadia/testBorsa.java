package it.uniroma3.diadia;

/**
 * Questa classe gestisce i test per la classe Borsa
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Attrezzo;
import it.uniroma3.diadia.Borsa;

class testBorsa {

	Borsa borsa;
	Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		borsa = new Borsa();
		attrezzo= new Attrezzo("Lanterna",3);
	}
	
	//------------TEST VARI-------------------------
	
	
	/**
	 * Controlla che gli attrezzi vengano 
	 * aggiunti correttamente
	 */
	@Test
	void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
	
	/**
	 * controlla che una volta inserito un attrezzo
	 * la funzione HasAttrezzo sia in grado di "leggerlo"
	 */
	@Test
	void testHasAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("Lanterna")); 
	}

	/**
	 * controlla che il risultato di GetAttrezzo 
	 * sia giusto
	 */
	@Test
	void testGetAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,borsa.getAttrezzo("Lanterna"));
	}
	
	/**
	 * controlla che isEmpty funzioni
	 */
	@Test
	void testIsEmpty() {
		borsa.addAttrezzo(attrezzo);
		assertFalse(borsa.isEmpty());
	}
	
	/**
	 * controlla che getPeso funzioni correttamente
	 */
	@Test
	void testGetPeso() {
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(new Attrezzo("Torcia",2));
		assertEquals(5,borsa.getPeso());
	}
}
