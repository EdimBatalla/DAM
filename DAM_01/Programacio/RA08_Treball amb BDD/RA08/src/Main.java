import java.util.List;

public class Main {

	public static void main(String[] args) {
		GestorBD gestor = new GestorBD();
        gestor.connectarAmbVariablesEntorn();

        int idClient = 1; // prova amb un client existent
        List<Cotxe> cotxes = gestor.obtenirCotxesPerClient(idClient);

        for (Cotxe c : cotxes) {
            System.out.println(c);
        }

        gestor.tancarConnexio();
    }
}