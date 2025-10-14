import java.util.ArrayList;

public class Taller {

	private ArrayList<Client> clients;
	
	public Taller() {
		this.clients = new ArrayList<>();
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public void agefirClients(Client client) {
		this.clients.add(client);
	}

	public ArrayList<Client> consultarClients() {
		return this.clients;
	}

	public void eliminarClient(Client client) {
		this.clients.remove(client);
	}

	public int comptarClients() {
		return this.clients.size();
	}

	public void afegirReparacio(Cotxe cotxe, Reparacio reparacio) {
		cotxe.getReparacions().add(reparacio);
	}
	
	public void toStringReparacio(Cotxe cotxe) {
		for (Reparacio reparacio : cotxe.getReparacions()) {
			System.out.println(reparacio.toString());
		}
	}
}
