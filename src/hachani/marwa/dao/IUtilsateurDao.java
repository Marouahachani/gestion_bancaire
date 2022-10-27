package hachani.marwa.dao;

import hachani.marwa.metier.Utilisateur;

public interface IUtilsateurDao {
	public Utilisateur checkLogin(String email, String password);
}
