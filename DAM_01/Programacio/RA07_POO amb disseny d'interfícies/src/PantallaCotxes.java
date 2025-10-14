import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PantallaCotxes {
    private Client client;
    private Taller taller;
    private ScreenManager screenManager;

    private TextField matriculaField, modelField, marcaField, anyField;
    private ListView<Cotxe> llistaCotxes;

    public PantallaCotxes(Client client, Taller taller, ScreenManager screenManager) {
        this.client = client;
        this.taller = taller;
        this.screenManager = screenManager;
    }

    public Parent getView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label titol = new Label("Cotxes de " + client.getNom());

        // Formulari
        matriculaField = new TextField();
        matriculaField.setPromptText("Matrícula");

        modelField = new TextField();
        modelField.setPromptText("Model");

        marcaField = new TextField();
        marcaField.setPromptText("Marca");

        anyField = new TextField();
        anyField.setPromptText("Any");

        Button btnAfegir = new Button("Afegir cotxe");
        btnAfegir.setOnAction(e -> afegirCotxe());

        Button btnTornar = new Button("Tornar");
        btnTornar.setOnAction(e -> screenManager.setPantalla(new PantallaClients(taller, screenManager).getView()));

        HBox accions = new HBox(10, btnAfegir, btnTornar);

        // Llista de cotxes
        llistaCotxes = new ListView<>();
        actualitzarCotxes();

        // Accés a la pantalla de reparacions
        llistaCotxes.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                Cotxe seleccionat = llistaCotxes.getSelectionModel().getSelectedItem();
                if (seleccionat != null) {
                    screenManager.setPantalla(
                        new PantallaReparacions(seleccionat, taller, screenManager).getView()
                    );
                }
            }
        });

        root.getChildren().addAll(
            titol,
            new Label("Afegir cotxe:"),
            matriculaField,
            modelField,
            marcaField,
            anyField,
            accions,
            new Label("Cotxes registrats (doble clic per veure reparacions):"),
            llistaCotxes
        );

        return root;
    }

    private void afegirCotxe() {
        String matricula = matriculaField.getText().trim();
        String model = modelField.getText().trim();
        String marca = marcaField.getText().trim();
        String any = anyField.getText().trim();

        if (!matricula.isEmpty() && !model.isEmpty() && !marca.isEmpty() && !any.isEmpty()) {
            Cotxe cotxe = new Cotxe(matricula, model, marca, any);
            client.agefirCotxe(cotxe);
            actualitzarCotxes();

            matriculaField.clear();
            modelField.clear();
            marcaField.clear();
            anyField.clear();
        } else {
            mostrarAlerta("Tots els camps són obligatoris.");
        }
    }

    private void actualitzarCotxes() {
        llistaCotxes.getItems().setAll(client.getCotxes());
    }

    private void mostrarAlerta(String missatge) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertència");
        alert.setHeaderText(null);
        alert.setContentText(missatge);
        alert.showAndWait();
    }
}
