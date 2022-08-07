package hachani.marwa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hachani.marwa.metier.Compte;
import hachani.marwa.metier.client;

public class CompteDaoImpl implements ICompteDao{
	Connection cnx = SingletonConnection.getConnection();
	@Override
	public Compte save(Compte cpt) {
		
			PreparedStatement cps;
			try {
				cps = cnx.prepareStatement("Insert into Compte (numCompte, "
																				+ "dateCreationCompte, "
																				+ "soldeCompte, "
																				+ "typeCompte, "
																				+ "taux, "
																				+ "decouvert, "
																				+ "idClient) values(?,?,?,?,?,?,?)");
				
				cps.setString(1, cpt.getNumCompte());
				cps.setDate(2, cpt.getDateCreationCompte());
				cps.setDouble(3, cpt.getSoldeCompte());
				cps.setString(4, cpt.getTypeCompte());
				cps.setDouble(5, cpt.getTaux());
				cps.setDouble(6, cpt.getDecouvert());
				cps.setInt(7, cpt.getClient().getId());
				
				cps.executeUpdate();
				cps.close();
				
				
					return cpt;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			

		return null;
	}

	@Override
	public Compte update(Compte cpt) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update Compte set"
					
					+ " dateCreationCompte = ?,"
					+ " soldeCompte = ?,"
					+ " typeCompte = ?,"
					+ " taux= ?,"
					+ " decouvert = ?"
					+ " where numCompte = ?");
			
		
			cps.setDate(1, cpt.getDateCreationCompte());
			cps.setDouble(2, cpt.getSoldeCompte());
			cps.setString(3, cpt.getTypeCompte());
			cps.setDouble(4, cpt.getTaux());
			cps.setDouble(5, cpt.getDecouvert());
			cps.setString(6, cpt.getNumCompte());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(cpt.getNumCompte());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(Compte cpt) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from Compte where numCompte = ?");
			
			cps.setString(1, cpt.getNumCompte());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	
	

	@Override
	public ArrayList<Compte> getAll(int idClient) {
		ArrayList<Compte> listCompte =  new ArrayList<Compte>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from Compte where idClient = ?");
			
			cps.setInt(1, idClient);
			ResultSet crs = cps.executeQuery();
			
			Compte cpt ;
			
			while(crs.next()) {
				cpt = new Compte();
				cpt.setNumCompte(crs.getString("NumCompte"));
				cpt.setSoldeCompte(crs.getDouble("SoldeCompte"));
				cpt.setDateCreationCompte(crs.getDate("DateCreationCompte"));
				cpt.setTypeCompte(crs.getString("typeCompte"));
				cpt.setTaux(crs.getDouble("taux"));
				cpt.setDecouvert(crs.getDouble("decouvert"));
				
				listCompte.add(cpt);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCompte;
	}
	
	@Override
	public ArrayList<Compte> getAll() {
		ArrayList<Compte> listCompte =  new ArrayList<Compte>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from Compte");			
			ResultSet crs = cps.executeQuery();
			
			Compte cpt ;
			
			while(crs.next()) {
				cpt = new Compte();
				cpt.setNumCompte(crs.getString("NumCompte"));
				cpt.setSoldeCompte(crs.getDouble("SoldeCompte"));
				cpt.setDateCreationCompte(crs.getDate("DateCreationCompte"));
				cpt.setTypeCompte(crs.getString("typeCompte"));
				cpt.setTaux(crs.getDouble("taux"));
				cpt.setDecouvert(crs.getDouble("decouvert"));
				
				listCompte.add(cpt);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCompte;
	}
	
		
	

	@Override
	public Compte find(String numCompte) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from Compte where numCompte = ?");
			
			cps.setString(1, numCompte);
			ResultSet crs = cps.executeQuery();
			
			
			if(crs.next()) {
				Compte cpt = new Compte();
				cpt.setNumCompte(crs.getString("NumCompte"));
				cpt.setSoldeCompte(crs.getDouble("SoldeCompte"));
				cpt.setDateCreationCompte(crs.getDate("DateCreationCompte"));
				cpt.setTypeCompte(crs.getString("typeCompte"));
				cpt.setTaux(crs.getDouble("taux"));
				cpt.setDecouvert(crs.getDouble("decouvert"));
				ClientDaoImpl cdi=new ClientDaoImpl();
				cpt.setClient(cdi.find(crs.getInt("idClient")));
				
				
				return cpt;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	

	

	

	
}

//Client ----> IClientDao ----> ClientDaoImpl ----> SigletonConnection ----> Jdbc ----> Mysql(SGBDR)