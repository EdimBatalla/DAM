import java.util.ArrayList;

public class Client {

	private String nom;
	private String telefon;
	ArrayList<Cotxe> cotxes;

	public Client(String nom, String telefon) {
		this.nom = nom;
		this.telefon = telefon;
		this.cotxes = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public ArrayList<Cotxe> getCotxes() {
		return cotxes;
	}

	public void setCotxes(ArrayList<Cotxe> cotxes) {
		this.cotxes = cotxes;
	}
	
	public String toString() {
		return "Nom: " + nom + " | Telf.: " + telefon;
	}

	public void agefirCotxe(Cotxe cotxe) {
		this.cotxes.add(cotxe);

	}

}
