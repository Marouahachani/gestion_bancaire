package hachani.marwa.dao;
import java.util.ArrayList;

import hachani.marwa.metier.Compte;
import hachani.marwa.metier.Demande;
import hachani.marwa.metier.client;

	public interface IDemandeDao {
		Demande save(Demande dmn);
		Demande update(Demande dmn);
		int delete (Demande dmn);
		
		
		ArrayList<Demande>getAll(int idClient);
		
		Demande find(String num);
		
		
	
		

	}


