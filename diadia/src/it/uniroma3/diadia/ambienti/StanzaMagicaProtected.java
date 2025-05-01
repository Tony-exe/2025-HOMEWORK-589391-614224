package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		}
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
		}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		 if (this.getNumeroAttrezzi() < 10) {
			 if(contatoreAttrezziPosati<sogliaMagica) {
				this.attrezzi[this.numeroAttrezzi] = attrezzo;
	        	this.numeroAttrezzi++;
	        	contatoreAttrezziPosati++;
			 }
			 else {
	        	this.attrezzi[this.numeroAttrezzi] = modificaAttrezzo(attrezzo);
	        	this.numeroAttrezzi++;
			 }
			 
			 return true;
	        }
	        else {
	        	return false;
	        }
		 
	}
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
