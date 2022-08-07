package hachani.marwa.dao;
import java.util.ArrayList;

import hachani.marwa.metier.Compte;
import hachani.marwa.metier.client;

	public interface ICompteDao {
		Compte save(Compte cpt);
		Compte update(Compte cpt);
		int delete (Compte cpt);
		
		
		ArrayList<Compte>getAll(int idClient);
		ArrayList<Compte>getAll();

		
		Compte find(String numCompte);
		
		
	
		

	}


