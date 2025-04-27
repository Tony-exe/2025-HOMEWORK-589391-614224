package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;

public interface Comando {
	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);
	
	/**
	 * set parametro del comando
	 * @param parametro
	 */
	public void setParametro(String parametro);
}
