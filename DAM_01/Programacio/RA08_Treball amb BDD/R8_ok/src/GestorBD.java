import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class GestorBD {
    private static Connection conn = null;

    public static Connection connectar() {
        if (conn != null) return conn;

        try (InputStream input = GestorBD.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexió establerta correctament!");
        } catch (IOException | SQLException e) {
            System.out.println("Error de connexió: " + e.getMessage());
        }

        return conn;
    }
}
