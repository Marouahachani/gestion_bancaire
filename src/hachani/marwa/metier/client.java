package hachani.marwa.metier;

import java.sql.Date;
import java.util.ArrayList;



public class client{
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String tel;
	private String mail;
	private String Civilite; 
	
	
	
	public client() {
		
	
	}
	
	
	
	
	public client(String nom, String prenom, Date dateNaissance, String adresse, String tel,
			String mail, String civilite) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		Civilite = civilite;
	}

	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public Date getDateNaissance() {
		return dateNaissance;
	}




	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}




	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}




	public String getCivilite() {
		return Civilite;
	}




	public void setCivilite(String civilite) {
		Civilite = civilite;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresse=" + adresse + ", tel=" + tel + ", mail=" + mail + ", civilite=" + Civilite + "]";
	}

	//private ArrayList<Compte> comptes = new ArrayList<Compte>();
	//private ArrayList<DemandeCredit> credit = new ArrayList<DemandeCredit>();
}




	