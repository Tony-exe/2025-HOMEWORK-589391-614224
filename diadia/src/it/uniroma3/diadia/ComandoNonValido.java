package it.uniroma3.diadia;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println("Comando non valido!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
