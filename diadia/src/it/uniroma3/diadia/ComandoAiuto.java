package it.uniroma3.diadia;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai + direzione(nord, sud, est, ovest)", "prendi + oggetto", "posa", "guarda", "aiuto", "fine"};
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println("Questi sono i comandi che puoi utilizzare:");
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.println(" - "+elencoComandi[i]);
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
