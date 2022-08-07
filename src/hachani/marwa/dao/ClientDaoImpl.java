package hachani.marwa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hachani.marwa.metier.client;

public class ClientDaoImpl implements IClientDao{
	Connection cnx = SingletonConnection.getConnection();
	@Override
	public client save(client c) {
		
			PreparedStatement cps;
			try {
				cps = cnx.prepareStatement("Insert into client (nom, "
																				+ "prenom, "
																				+ "date_naissance, "
																				+ "tel, "
																				+ "adresse, "
																				+ "mail, "
																				+ "civilite) values(?,?,?,?,?,?,?)");
				
				cps.setString(1, c.getNom());
				cps.setString(2, c.getPrenom());
				cps.setDate(3, c.getDateNaissance());
				cps.setString(4, c.getTel());
				cps.setString(5, c.getAdresse());
				cps.setString(6, c.getMail());
				cps.setString(7, c.getCivilite());
				
				cps.executeUpdate();
				cps.close();
				
				cps =cnx.prepareStatement("select max(id) as last_id from client");
				ResultSet crs = cps.executeQuery();
				
				if(crs.next()) {
					c.setId(crs.getInt("last_id"));
					return c;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			

		return null;
	}

	@Override
	public client update(client c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update client set"
					+ " nom = ?,"
					+ " prenom = ?,"
					+ " tel = ?,"
					+ " adresse= ?,"
					+ " mail = ?,"
					+ " civilite = ?,"
					+ " date_naissance = ?"
					+ " where id = ?");
			
			cps.setString(1, c.getNom());
			cps.setString(2, c.getPrenom());
			cps.setDate(7, c.getDateNaissance());
			cps.setString(3, c.getTel());
			cps.setString(4, c.getAdresse());
			cps.setString(5, c.getMail());
			cps.setString(6, c.getCivilite());
			cps.setInt(8, c.getId());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(c.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(client c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from client where id = ?");
			
			cps.setInt(1, c.getId());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<client> getAll() {
		ArrayList<client> listClient =  new ArrayList<client>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client");
			
			
			ResultSet crs = cps.executeQuery();
			
			client c ;
			
			while(crs.next()) {
				c = new client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				listClient.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}

	@Override
	public ArrayList<client> getAll(String nom) {
		ArrayList<client> listClient =  new ArrayList<client>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom like ?");
			
			cps.setString(1, '%' + nom + '%');
			ResultSet crs = cps.executeQuery();
			
			client c ;
			
			while(crs.next()) {
				c = new client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				listClient.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}
	
	
	@Override
	public ArrayList<client> getAll(String nom, String prenom) {
		ArrayList<client> listClient =  new ArrayList<client>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom like ? and prenom like ?");
			
			cps.setString(1, '%' + nom + '%');
			cps.setString(2, '%' + prenom + '%');
			ResultSet crs = cps.executeQuery();
			
			client c ;
			
			while(crs.next()) {
				c = new client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				listClient.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}
	

	@Override
	public client find(int id) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where id = ?");
			
			cps.setInt(1, id);
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				client c = new client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public client find(String nom) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom = ?");
			
			cps.setString(1, nom);
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				client c = new client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public client find(String nom, String prenom) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom = ? and prenom = ?");
			
			cps.setString(1, nom);
			cps.setString(2, prenom);
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				client c = new client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int count() {
		try {
			PreparedStatement cps = cnx.prepareStatement("select count(*) as total from client");
			
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) return crs.getInt("total");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}

//Client ----> IClientDao ----> ClientDaoImpl ----> SigletonConnection ----> Jdbc ----> Mysql(SGBDR)