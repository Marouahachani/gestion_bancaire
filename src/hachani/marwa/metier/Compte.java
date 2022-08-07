package hachani.marwa.metier;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Compte {
	private String numCompte;// changer tt au string
	private double soldeCompte;
	private Date dateCreationCompte;
	private String typeCompte;
	private double taux;
	private double decouvert;
	private client client;

	public Compte() {
		super();
	}
	
		
	public Compte(String numCompte, double soldeCompte, Date dateCreationCompte, String typeCompte, double taux,
			double decouvert, client client) {
		super();
		this.numCompte = numCompte;
		this.soldeCompte = soldeCompte;
		this.dateCreationCompte = dateCreationCompte;
		this.typeCompte = typeCompte;
		this.taux = taux;
		this.decouvert = decouvert;
		this.client = client;

	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Date getDateCreationCompte() {
		return dateCreationCompte;
	}

	public void setDateCreationCompte(Date dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public client getClient() {
		return client;
	}

	public void setClient(client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", soldeCompte=" + soldeCompte + ", dateCreationCompte="
				+ dateCreationCompte + ", typeCompte=" + typeCompte + ", taux=" + taux + ", decouvert=" + decouvert
				+ ", client=" + client + "]";
	}

}
