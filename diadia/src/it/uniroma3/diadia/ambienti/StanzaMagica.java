package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
		}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
		
		 /*if (this.getNumeroAttrezzi() < 10) {
			 if(!isMagico(contatoreAttrezziPosati)) {
				this.getAttrezzi()[getNumeroAttrezzi()] = attrezzo;
	        	this.setNumeroAttrezzi(getNumeroAttrezzi()+1);
	        	contatoreAttrezziPosati++;
			 }
			 else {
	        	this.getAttrezzi()[getNumeroAttrezzi()] = modificaAttrezzo(attrezzo);
	        	this.setNumeroAttrezzi(getNumeroAttrezzi()+1);
			 }
			 
			 return true;
	        }
	        else {
	        	return false;
	        }
		 
	}
	public boolean isMagico(int posati) {
		return posati==sogliaMagica;
	}*/
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		System.out.println("poof!");
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		System.out.println("/*/*/*/*/*/*  "+nomeInvertito.toString()+"  /*/*/*/*");
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
		}
}
