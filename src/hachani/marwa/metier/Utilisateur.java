package hachani.marwa.metier;

public class Utilisateur {


	private Integer active;

	private String login;

	private String pass;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Integer active, String login, String pass) {
		super();
		this.active = active;
		this.login = login;
		this.pass = pass;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Utilisateur [active=" + active + ", login=" + login + ", pass=" + pass + "]";
	}

}
