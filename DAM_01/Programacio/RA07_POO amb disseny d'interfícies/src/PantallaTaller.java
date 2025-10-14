import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PantallaTaller {
    private Taller taller;
    private ScreenManager screenManager;
    private static boolean tallerInicialitzat = false;

    public PantallaTaller(Taller taller, ScreenManager screenManager) {
        this.taller = taller;
        this.screenManager = screenManager;
        if (!tallerInicialitzat) {
            inicialitzarTaller();
            tallerInicialitzat = true;
        }
    }

    public Parent getView() {
        BorderPane root = new BorderPane();

        //Botons superiors
        Button btnClients = new Button("Clients");
        btnClients.setOnAction(e -> screenManager.setPantalla(new PantallaClients(taller, screenManager).getView()));

        Button btnCotxes = new Button("Cotxes");
        btnCotxes.setOnAction(e -> screenManager.setPantalla(new PantallaCotxesGeneral(taller, screenManager).getView()));

        Button btnReparacions = new Button("Reparacions");
        btnReparacions.setOnAction(e -> screenManager.setPantalla(new PantallaReparacionsGeneral(taller, screenManager).getView()));

        Button btnResum = new Button("Resum");
        btnResum.setOnAction(e -> screenManager.setPantalla(new PantallaResum(taller, screenManager).getView()));

        Button btnSortir = new Button("Sortir");
        btnSortir.setOnAction(e -> root.getScene().getWindow().hide());

        HBox botoBox = new HBox(20, btnClients, btnCotxes, btnReparacions, btnResum, btnSortir);
        botoBox.setAlignment(Pos.CENTER);
        botoBox.setPadding(new Insets(60, 20, 20, 20));

        root.setTop(botoBox);

        //Imatge centrada verticalment al centre
        Image image = new Image("file:mecanic.jpg"); // Assegura't que el fitxer existeix
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        VBox imageBox = new VBox(imageView);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.setPadding(new Insets(20));

        root.setCenter(imageBox); // La imatge ocupa el centre

        return root;
    }

    private void inicialitzarTaller() {
        Client client1 = new Client("Caravaca", "111111111");
        Client client2 = new Client("Marco", "222222222");
        Client client3 = new Client("Pedro", "333333333");
        Client client4 = new Client("Nidaa", "444444444");
        taller.agefirClients(client1);
        taller.agefirClients(client2);
        taller.agefirClients(client3);
        taller.agefirClients(client4);

        Cotxe cotxe1 = new Cotxe("6767HDR", "Polo", "Volskwagen", "2020");
        Cotxe cotxe2 = new Cotxe("2222BBB", "2CV", "Citroen", "2021");
        Cotxe cotxe3 = new Cotxe("3333CCC", "Clase A", "Mercedes", "2022");
        Cotxe cotxe4 = new Cotxe("4444DDD", "A4", "Audi", "2023");
        client1.agefirCotxe(cotxe1);
        client2.agefirCotxe(cotxe2);
        client3.agefirCotxe(cotxe3);
        client4.agefirCotxe(cotxe4);

        Reparacio r1 = new Reparacio("Canvi d'oli", "2025-01-01", 50.0, true);
        Reparacio r2 = new Reparacio("Revisió", "2025-02-02", 100.0, false);
        Reparacio r3 = new Reparacio("Canvi de pneumàtics", "2025-03-03", 200.0, true);
        Reparacio r4 = new Reparacio("Reparació de frens", "2025-04-04", 150.0, false);
        r1.setEstat("finalitzada");
        r2.setEstat("pendent");
        r3.setEstat("finalitzada");
        r4.setEstat("en reparació");

        cotxe1.getReparacions().add(r1);
        cotxe2.getReparacions().add(r2);
        cotxe3.getReparacions().add(r3);
        cotxe4.getReparacions().add(r4);
    }
}
