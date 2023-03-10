package Entite;

public class Client {
	private int id;
	private String nom;
	private String telephone;
	private String email;
	private static int comp;

	public Client(int id, String nom, String telephone, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
	}

	public Client(String nom, String telephone, String email) {
		this.id = ++comp;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n id : " + id + ", nom : " + nom + ", telephone : " + telephone + ", email : " + email;
	}

}
