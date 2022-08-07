package hachani.marwa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hachani.marwa.metier.Compte;
import hachani.marwa.metier.Demande;
import hachani.marwa.metier.client;

public class DemandeDaoImpl implements IDemandeDao{
	Connection cnx = SingletonConnection.getConnection();
	@Override
	public Demande save(Demande dmn) {
		
			PreparedStatement cps;
			try {
				cps = cnx.prepareStatement("Insert into Demande (num, "
																				+ "date, "
																				+ "montant, "
																				+ "duree, "
																				+ "taux, "
																				+ "mensualite, "
																				+ "etat, "
																				+ "idClient) values(?,?,?,?,?,?,?,?)");
				
				cps.setString(1, dmn.getNum());
				cps.setDate(2, dmn.getDate());
				cps.setDouble(3, dmn.getMontant());
				cps.setInt(4, dmn.getDuree());
				cps.setDouble(5, dmn.getTaux());
				cps.setDouble(6, dmn.getMensualite());
				cps.setString(7, dmn.getEtat());
				cps.setInt(8, dmn.getClient().getId());
				
				cps.executeUpdate();
				cps.close();
				
				
					return dmn;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			

		return null;
	}

	@Override
	public Demande update(Demande dmn) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update Demande set"		
					+ " date = ?,"
					+ " montant = ?,"
					+ " duree = ?,"
					+ " taux= ?,"
					+ " mensualite= ?,"
					+ " etat = ?"
					+ " where num = ?");
			
		
			cps.setDate(1, dmn.getDate());
			cps.setDouble(2, dmn.getMontant());
			cps.setInt(3, dmn.getDuree());
			cps.setDouble(4, dmn.getTaux());
			cps.setDouble(5, dmn.getMensualite());
			cps.setString(6, dmn.getEtat());
			cps.setString(7, dmn.getNum());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(dmn.getNum());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(Demande dmn) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from Demande where num = ?");
			
			cps.setString(1, dmn.getNum());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	
	

	@Override
	public ArrayList<Demande> getAll(int idClient) {
		ArrayList<Demande> listDemande =  new ArrayList<Demande>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from Demande where idClient = ?");
			
			cps.setInt(1, idClient);
			ResultSet crs = cps.executeQuery();
			
			Demande dmn ;
			
			while(crs.next()) {
				dmn = new Demande();
				dmn.setNum(crs.getString("Num"));
				dmn.setDate(crs.getDate("Date"));
				dmn.setMontant(crs.getDouble("montant"));
				dmn.setDuree(crs.getInt("duree"));
				dmn.setTaux(crs.getDouble("taux"));
				dmn.setMensualite(crs.getDouble("mensualite"));
				dmn.setEtat(crs.getString("etat"));
				
				listDemande.add(dmn);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDemande;
	}
	
	
	public ArrayList<Demande> getAll() {
		ArrayList<Demande> listDemande =  new ArrayList<Demande>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from Demande");			
			ResultSet crs = cps.executeQuery();
			
			Demande dmn ;
			
			while(crs.next()) {
				dmn = new Demande();
				dmn.setNum(crs.getString("NumCompte"));
				dmn.setDate(crs.getDate("Date"));
				dmn.setMontant(crs.getDouble("montant"));
				dmn.setDuree(crs.getInt("duree"));
				dmn.setTaux(crs.getDouble("taux"));
				dmn.setMensualite(crs.getDouble("mensualite"));
				dmn.setEtat(crs.getString("etat"));
				
				listDemande.add(dmn);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDemande;
	}
	
	
	
	

	@Override
	public Demande find(String num) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from Demande where num = ?");
			
			cps.setString(1, num);
			ResultSet crs = cps.executeQuery();
			
			
			if(crs.next()) {
				Demande dmn = new Demande();
				dmn.setNum(crs.getString("Num"));
				dmn.setDate(crs.getDate("Date"));
				dmn.setMontant(crs.getDouble("montant"));
				dmn.setDuree(crs.getInt("duree"));
				dmn.setTaux(crs.getDouble("taux"));
				dmn.setMensualite(crs.getDouble("mensualite"));
				dmn.setEtat(crs.getString("etat"));
				ClientDaoImpl cdi=new ClientDaoImpl();
				dmn.setClient(cdi.find(crs.getInt("idClient")));
				
				
				
				
				
				
				
				return dmn;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	

	

	

	
}

//Client ----> IClientDao ----> ClientDaoImpl ----> SigletonConnection ----> Jdbc ----> Mysql(SGBDR)