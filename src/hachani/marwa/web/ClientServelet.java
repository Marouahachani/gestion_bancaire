package hachani.marwa.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hachani.marwa.dao.ClientDaoImpl;
import hachani.marwa.dao.CompteDaoImpl;
import hachani.marwa.dao.DemandeDaoImpl;
import hachani.marwa.dao.UtilsateurDaoImpl;
import hachani.marwa.metier.Compte;
import hachani.marwa.metier.Demande;
import hachani.marwa.metier.Utilisateur;
import hachani.marwa.metier.client;


@WebServlet("/")
public class ClientServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientDaoImpl cdi = new ClientDaoImpl();
	private CompteDaoImpl cptdi = new CompteDaoImpl();
	private DemandeDaoImpl dmndi = new DemandeDaoImpl();
	UtilsateurDaoImpl uti= new UtilsateurDaoImpl();
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		ArrayList<client> clients;
		ArrayList<Compte> comptes;
		ArrayList<Demande> demandes;
		client c;
		Compte cpt;
		Demande dmn;
		Utilisateur u;
		
		
   
		
		
		switch(path) {
			case "/list-client":
				clients = cdi.getAll();
				
				//passer le tableau des clients a la vue (liste-client.jsp)
				
				request.setAttribute("clients", clients);
				
			request.getRequestDispatcher("list-client.jsp").forward(request,response);
			break;
			case "/nouveau-client":
				request.getRequestDispatcher("nouveau-client.jsp").forward(request,response);
				break;
				
		
			case"/login":
				String login= request.getParameter("login");
				String pass= request.getParameter("pass");
				
		         
			u = uti.checkLogin(login, pass);
			String destPage = "login.jsp";
			 
			if (u != null) {
			    HttpSession session = request.getSession();
			    session.setAttribute("user", u);
			    System.out.println(u.toString());
			    destPage = "index.jsp";
			} else {
			    String message = "veuillez verifier le login et/ou mot de passe";
			    request.setAttribute("message", message);
			}
			 
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
				
				
		
		
				break;
			
			case"/save-client":
				String nom= request.getParameter("nom");
				String prenom= request.getParameter("prenom");
				String dateNaissance= request.getParameter("date-naissance");
				String tel= request.getParameter("tel");
				String mail= request.getParameter("mail");
				String adresse= request.getParameter("adresse");
				String civilite= request.getParameter("civilite");
				
				
				
				c = new client(nom, prenom, Date.valueOf(dateNaissance), adresse, tel, mail, civilite);
				c= cdi.save(c);
				request.setAttribute("client", c);
				request.getRequestDispatcher("confirmation.jsp").forward(request, response);
				break;
				
				
			case"/delete-client":
				//le code supprimer le client
				int id = Integer.parseInt(request.getParameter("id"));
			    c= new client();
				c.setId(id);
				cdi.delete(c);
				
				
				response.sendRedirect("list-client");
				break;
			
			case "/detail-client":
				int idclient = Integer.parseInt(request.getParameter("id"));
				c = cdi.find(idclient); 
				request.setAttribute("client" , c); 
				request.getRequestDispatcher("detail.jsp").forward(request, response); 
				break; 
				
			case "/find": 
				nom = request.getParameter("nom"); 
				prenom = request.getParameter("prenom"); 
				clients = cdi.getAll(nom, prenom); 
				//Passer le tableau des clients a la vue (list-client.jsp) 
				request.setAttribute("clients", clients); 
				//afficher une page jsp 
				request.getRequestDispatcher("list-client.jsp").forward(request, response);
				break; 		
				
				
				
				
			case "/list-compte":
				String idClientParam = request.getParameter("idclient");
				if ("".equals(idClientParam)) {
					comptes = cptdi.getAll();
					c = new client();
				} else {
					idclient = Integer.parseInt(idClientParam);
					comptes = cptdi.getAll(idclient);
					c = cdi.find(idclient);
					request.setAttribute("client", c);
				}
				request.setAttribute("comptes", comptes);
				request.setAttribute("client", c);

				request.getRequestDispatcher("list-compte.jsp").forward(request, response);
				break;
			case"/nouveau-compte":
				
				idclient= Integer.parseInt(request.getParameter("idclient"));
				c=cdi.find(idclient);
				request.setAttribute("clients", c);
				
				request.getRequestDispatcher("nouveau-compte.jsp").forward(request,response);
			break;
			
			case"/save-compte":
				String numCompte= request.getParameter("numCompte");
				double soldeCompte= Double.parseDouble(request.getParameter("soldeCompte"));
				String dateCreationCompte= request.getParameter("dateCreationCompte");
				String typeCompte= request.getParameter("typeCompte");
				double taux= Double.parseDouble(request.getParameter("taux"));
				double decouvert= Double.parseDouble(request.getParameter("decouvert"));
				int idcl = Integer.parseInt(request.getParameter("idClient"));
				
				c=cdi.find(idcl);
				cpt = new Compte(numCompte, soldeCompte, Date.valueOf(dateCreationCompte), typeCompte, taux, decouvert,c);
				cpt= cptdi.save(cpt);
				request.setAttribute("compte", cpt);
				request.getRequestDispatcher("confirmation-compte.jsp").forward(request, response);
				break;
				
			case"/update-compte":
				 numCompte= request.getParameter("numCompte");
				 soldeCompte= Double.parseDouble(request.getParameter("soldeCompte"));
				 typeCompte= request.getParameter("typeCompte");
				 taux= Double.parseDouble(request.getParameter("taux"));
				 decouvert= Double.parseDouble(request.getParameter("decouvert"));
				 idcl = Integer.parseInt(request.getParameter("idClient"));
				
				c=cdi.find(idcl);
				cpt = cptdi.find(numCompte);
				cpt.setSoldeCompte(soldeCompte);
				cpt.setTypeCompte(typeCompte);
				cpt.setDecouvert(decouvert);
				cpt.setTaux(taux);
				cpt= cptdi.update(cpt);
				request.setAttribute("compte", cpt);
				request.getRequestDispatcher("confirmation-compte.jsp").forward(request, response);
				break;	
				
				
				
			case"/delete-compte":
				
				String numCompte1 = request.getParameter("numCompte");
			    cpt= cptdi.find(numCompte1);
				
				cptdi.delete(cpt);
				
				
				response.sendRedirect("list-compte?idclient=" + cpt.getClient().getId());
				break;
				
				
			case"/modifier-compte":
				String numeCompte1= request.getParameter("numCompte");
				cpt= cptdi.find(numeCompte1);
				
				request.setAttribute("compte", cpt);
				request.getRequestDispatcher("detail-compte.jsp").forward(request, response);
				
				
				break;
				
				
				
			case "/list-Demande":
				idclient = Integer.parseInt(request.getParameter("idclient"));
				demandes = dmndi.getAll(idclient);
			
				request.setAttribute("demande", demandes);
				c=cdi.find(idclient);
				request.setAttribute("client", c);
				request.getRequestDispatcher("list-Demande.jsp").forward(request,response);
				break;
				
				
			case"/nouveau-Demande":
				
				idclient= Integer.parseInt(request.getParameter("idclient"));
				c=cdi.find(idclient);
				request.setAttribute("clients", c);
				
				request.getRequestDispatcher("nouveau-Demande.jsp").forward(request,response);
			break;
			
			
			case"/save-Demande":
				String num= request.getParameter("num");
				String date= request.getParameter("date");
				double montant= Double.parseDouble(request.getParameter("montant"));
				int duree=Integer.parseInt(request.getParameter("duree"));
				double tau1= Double.parseDouble(request.getParameter("taux"));
				double mensualite= Double.parseDouble(request.getParameter("mensualite"));
				String etat= request.getParameter("etat");
				int idcli = Integer.parseInt(request.getParameter("idClient"));
				
				c=cdi.find(idcli);
				dmn = new Demande(num, Date.valueOf(date), montant, duree, tau1, mensualite, etat ,c);
				dmn= dmndi.save(dmn);
				request.setAttribute("demande", dmn);
				request.getRequestDispatcher("confirmation-Demande.jsp").forward(request, response);
				break;
				
				
			case"/delete-Demande":
				
				String num1 = request.getParameter("num");
			    dmn= dmndi.find(num1);
				
				dmndi.delete(dmn);
				
				
				response.sendRedirect("list-Demande?idclient=" + dmn.getClient().getId());
				break;
				
			case"/modifier-Demande":
				 String nume= request.getParameter("num");
				dmn= dmndi.find(nume);
				
				request.setAttribute("demande", dmn);
				request.getRequestDispatcher("detail-Demande.jsp").forward(request, response);
				
				
				
				
				break;
			case"/update-Demande":
				 num= request.getParameter("num");
				 date= request.getParameter("date");
				 montant= Double.parseDouble(request.getParameter("montant"));
				 duree= Integer.parseInt(request.getParameter("duree"));
				 taux= Double.parseDouble(request.getParameter("taux"));
				 mensualite= Double.parseDouble(request.getParameter("mensualite"));
				 etat= request.getParameter("etat");
				 idcl = Integer.parseInt(request.getParameter("idClient"));
				
				c=cdi.find(idcl);
				dmn = dmndi.find(num);
				dmn.setEtat(etat);
				
				dmn= dmndi.update(dmn);
				request.setAttribute("demande", dmn);
				request.getRequestDispatcher("confirmation-Demande.jsp").forward(request, response);
				break;	
				
			
			
			
			
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		
		

		
	}

	
}
