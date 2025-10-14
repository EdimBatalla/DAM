import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PantallaReparacions {
    private Cotxe cotxe;
    private ScreenManager screenManager;
    private Taller taller;

    private TextField descripcioField, preuField;
    private ListView<HBox> llistaReparacions;

    public PantallaReparacions(Cotxe cotxe, Taller taller, ScreenManager screenManager) {
        this.cotxe = cotxe;
        this.taller = taller;
        this.screenManager = screenManager;
    }

    public Parent getView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label titol = new Label("Reparacions per al cotxe: " + cotxe.getMatricula());

        descripcioField = new TextField();
        descripcioField.setPromptText("Descripció");

        preuField = new TextField();
        preuField.setPromptText("Preu");

        Button btnAfegir = new Button("Afegir reparació");
        btnAfegir.setOnAction(e -> afegirReparacio());

        Button btnTornar = new Button("Tornar");
        btnTornar.setOnAction(e ->
            screenManager.setPantalla(new PantallaCotxes(trobarClient(), taller, screenManager).getView())
        );

        HBox accions = new HBox(10, btnAfegir, btnTornar);

        llistaReparacions = new ListView<>();
        actualitzarLlista();

        root.getChildren().addAll(
            titol,
            new Label("Afegir nova reparació:"),
            descripcioField,
            preuField,
            accions,
            new Label("Reparacions registrades:"),
            llistaReparacions
        );

        return root;
    }

    private void afegirReparacio() {
        String descripcio = descripcioField.getText().trim();
        String preuText = preuField.getText().trim();

        if (!descripcio.isEmpty() && !preuText.isEmpty()) {
            try {
                double preu = Double.parseDouble(preuText);
                String dataActual = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
                Reparacio nova = new Reparacio(descripcio, dataActual, preu, false); // comença com a pendent
                nova.setEstat("pendent");
                cotxe.getReparacions().add(nova);
                actualitzarLlista();
                descripcioField.clear();
                preuField.clear();
            } catch (NumberFormatException ex) {
                mostrarAlerta("El preu ha de ser un número vàlid.");
            }
        } else {
            mostrarAlerta("Has d'omplir tots els camps.");
        }
    }

    private void actualitzarLlista() {
        llistaReparacions.getItems().clear();

        for (Reparacio r : cotxe.getReparacions()) {
            Label text = new Label(r.toString());

            // Quadrat de color
            Region estatColor = new Region();
            estatColor.setPrefSize(15, 15);
            estatColor.setStyle("-fx-background-color: " + colorPerEstat(r.getEstat()) + ";"
                    + "-fx-border-color: black;");

            // ComboBox per canviar estat
            ComboBox<String> comboEstat = new ComboBox<>();
            comboEstat.getItems().addAll("pendent", "en reparació", "finalitzada");
            comboEstat.setValue(r.getEstat());
            comboEstat.setOnAction(e -> {
                r.setEstat(comboEstat.getValue());
                actualitzarLlista();
            });

            HBox fila = new HBox(10, estatColor, text, comboEstat);
            fila.setPadding(new Insets(5));

            if (r.getEstat().equals("finalitzada")) {
                fila.setStyle("-fx-background-color: #ddffdd;"); // verd clar
            }

            llistaReparacions.getItems().add(fila);
        }
    }

    private String colorPerEstat(String estat) {
        return switch (estat) {
            case "pendent" -> "red";
            case "en reparació" -> "orange";
            case "finalitzada" -> "green";
            default -> "gray";
        };
    }

    private void mostrarAlerta(String missatge) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertència");
        alert.setHeaderText(null);
        alert.setContentText(missatge);
        alert.showAndWait();
    }

    private Client trobarClient() {
        for (Client c : taller.getClients()) {
            if (c.getCotxes().contains(cotxe)) return c;
        }
        return null;
    }
}
