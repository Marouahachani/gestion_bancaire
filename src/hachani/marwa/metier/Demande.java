package hachani.marwa.metier;





	import java.sql.Date;
	import java.util.ArrayList;

import com.mysql.cj.xdevapi.Client;

	public class Demande{
		private String num;
		private  Date date;
		private  double montant;
		private  int duree;
		private  double taux;
		private  double mensualite;
		private String etat;
		private client client;
		
		
		
		
		
		

		
		public Demande() {
			super();
		}

		

			
		public Demande(String num, Date date, double montant, int duree, double taux, double mensualite, String etat,
				hachani.marwa.metier.client client) {
			super();
			this.num = num;
			this.date = date;
			this.montant = montant;
			this.duree = duree;
			this.taux = taux;
			this.mensualite = mensualite;
			this.etat = etat;
			this.client = client;
			
		}
		

		public String getNum() {
			return num;
		}

		public void setNum(String num) {
			this.num = num;
		}
		

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}




		public double getMontant() {
			return montant;
		}

		public void setMontant(double montant) {
			this.montant = montant;
		}




		public int getDuree() {
			return duree;
		}

		public void setDuree(int duree) {
			this.duree = duree;
		}




		public double getTaux() {
			return taux;
		}
		public void setTaux(double taux) {
			this.taux = taux;
		}




		public double getMensualite() {
			return mensualite;
		}
		public void setMensualite(double mensualite) {
			this.mensualite = mensualite;
		}




		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}




		public client getClient() {
			return client;
		}

		public void setClient(client client) {
			this.client = client;
		}




		@Override
		public String toString() {
			return "Demande [num=" + num + ", date=" + date + ", montant=" + montant + ", duree=" + duree + ", taux="
					+ taux + ", mensualite=" + mensualite + ", etat=" + etat + ", client=" + client + "]";
		}



		
	
		


	}
