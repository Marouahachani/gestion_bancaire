package hachani.marwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hachani.marwa.metier.Utilisateur;
import hachani.marwa.metier.client;

public class UtilsateurDaoImpl implements IUtilsateurDao {
	Connection cnx = SingletonConnection.getConnection();

	@Override
	public Utilisateur checkLogin(String login, String pass) {

		try {
			PreparedStatement cps = cnx.prepareStatement("select * from utilisateur where login = ? and pass = ?");

			cps.setString(1, login);
			cps.setString(2, pass);
			ResultSet crs = cps.executeQuery();

			if (crs.next()) {
				Utilisateur u = new Utilisateur();
				u.setLogin(crs.getString("login"));
				u.setPass(crs.getString("pass"));

				return u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
}
