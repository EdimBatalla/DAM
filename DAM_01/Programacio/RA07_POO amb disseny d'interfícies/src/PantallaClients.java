import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PantallaClients {
    private Taller taller;
    private ScreenManager screenManager;

    private ListView<Client> llistaClients;
    private TextField nomField, telefonField;

    public PantallaClients(Taller taller, ScreenManager screenManager) {
        this.taller = taller;
        this.screenManager = screenManager;
    }

    public Parent getView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        // Formulari
        nomField = new TextField();
        nomField.setPromptText("Nom");
        telefonField = new TextField();
        telefonField.setPromptText("Telèfon");

        Button btnAfegir = new Button("Afegir client");
        btnAfegir.setOnAction(e -> afegirClient());

        // Llista de clients
        llistaClients = new ListView<>();
        actualitzarLlista();

        // Doble clic per veure els cotxes del client
        llistaClients.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                Client seleccionat = llistaClients.getSelectionModel().getSelectedItem();
                if (seleccionat != null) {
                    screenManager.setPantalla(
                        new PantallaCotxes(seleccionat, taller, screenManager).getView()
                    );
                }
            }
        });

        // Botó modificar
        Button btnModificar = new Button("Modificar client");
        btnModificar.setOnAction(e -> modificarClient());

        // Botó tornar
        Button btnTornar = new Button("Tornar");
        btnTornar.setOnAction(e -> screenManager.setPantalla(new PantallaTaller(taller, screenManager).getView()));

        // Agrupem els botons d'acció
        HBox accions = new HBox(10, btnAfegir, btnModificar, btnTornar);

        root.getChildren().addAll(
            new Label("Afegir client:"),
            nomField,
            telefonField,
            accions,
            new Label("Clients actuals (doble clic per veure cotxes):"),
            llistaClients
        );

        return root;
    }

    private void afegirClient() {
        String nom = nomField.getText().trim();
        String telefon = telefonField.getText().trim();
        if (!nom.isEmpty() && !telefon.isEmpty()) {
            Client nou = new Client(nom, telefon);
            taller.agefirClients(nou);
            actualitzarLlista();
            nomField.clear();
            telefonField.clear();
        } else {
            mostrarAlerta("Has d’omplir el nom i el telèfon.");
        }
    }

    private void modificarClient() {
        Client seleccionat = llistaClients.getSelectionModel().getSelectedItem();
        if (seleccionat != null) {
            String nouNom = nomField.getText().trim();
            String nouTelefon = telefonField.getText().trim();
            if (!nouNom.isEmpty() && !nouTelefon.isEmpty()) {
                seleccionat.setNom(nouNom);
                seleccionat.setTelefon(nouTelefon);
                actualitzarLlista();
            } else {
                mostrarAlerta("No pots deixar camps buits.");
            }
        } else {
            mostrarAlerta("Selecciona un client per modificar.");
        }
    }

    private void actualitzarLlista() {
        llistaClients.getItems().setAll(taller.getClients());
    }

    private void mostrarAlerta(String missatge) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertència");
        alert.setHeaderText(null);
        alert.setContentText(missatge);
        alert.showAndWait();
    }
}

