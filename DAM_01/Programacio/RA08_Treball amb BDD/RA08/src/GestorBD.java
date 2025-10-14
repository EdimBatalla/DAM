import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {
    private Connection connexio;

    public void connectarAmbVariablesEntorn() {
        try {
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            connexio = DriverManager.getConnection(url, user, password);
            System.out.println("Connexió correcta.");
        } catch (SQLException e) {
            System.err.println("Error de connexió: " + e.getMessage());
        }
    }

    public List<Cotxe> obtenirCotxesPerClient(int idClient) {
        List<Cotxe> cotxes = new ArrayList<>();
        String query = "SELECT * FROM cotxes WHERE idClient = ?";

        try (PreparedStatement stmt = connexio.prepareStatement(query)) {
            stmt.setInt(1, idClient);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cotxe cotxe = new Cotxe(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("model"),
                    rs.getInt("idClient")
                );
                cotxes.add(cotxe);
            }
        } catch (SQLException e) {
            System.err.println("Error en obtenir cotxes: " + e.getMessage());
        }

        return cotxes;
    }

    public void tancarConnexio() {
        try {
            if (connexio != null) connexio.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
