package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String>parole;
		
	public Parole() {
		parole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//consente di inserire una parola nella struttura dati
		parole.add(p);
	}
	
	public List<String> getElenco() {
		//ritorna l'elenco di parole correnti inserite ordinate alfabeticamente
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		//elimina tutte le parole dalla struttura dati
		parole.clear();
	}
	
	public void delete(String st) {
		//elimina solo una specifica parola che gli passo come paramentro
		parole.remove(st);
	}

}
