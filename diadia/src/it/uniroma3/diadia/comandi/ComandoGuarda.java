package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		System.out.println(stanzaCorrente.toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
