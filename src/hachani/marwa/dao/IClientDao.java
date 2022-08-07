package hachani.marwa.dao;
import java.util.ArrayList;

import hachani.marwa.metier.client;

public interface IClientDao {
	client save(client c);
	client update(client c);
	int delete (client c);
	
	ArrayList<client>getAll();
	ArrayList<client>getAll(String nom);
	ArrayList<client> getAll(String nom, String prenom);
	
	client find(int id);
	client find(String nom );
	client find(String nom, String prenom);
	
	
	int count();
	

}
