import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class PantallaCotxesGeneral {
    private Taller taller;
    private ScreenManager screenManager;

    // Associar la línia de text amb l’objecte Cotxe real
    private HashMap<String, Cotxe> mapCotxes = new HashMap<>();

    public PantallaCotxesGeneral(Taller taller, ScreenManager screenManager) {
        this.taller = taller;
        this.screenManager = screenManager;
    }

    public Parent getView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label titol = new Label("Tots els cotxes del taller:");
        ListView<String> llistaCotxes = new ListView<>();

        // Omplim la llista i guardem associació text ↔ cotxe
        for (Client c : taller.getClients()) {
            for (Cotxe co : c.getCotxes()) {
                String entrada = c.getNom() + " → " + co.toString();
                mapCotxes.put(entrada, co);
                llistaCotxes.getItems().add(entrada);
            }
        }

        // 🔁 Clic sobre cotxe per veure reparacions
        llistaCotxes.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                String seleccionat = llistaCotxes.getSelectionModel().getSelectedItem();
                if (seleccionat != null) {
                    Cotxe cotxe = mapCotxes.get(seleccionat);
                    screenManager.setPantalla(new PantallaReparacions(cotxe, taller, screenManager).getView());
                }
            }
        });

        Button btnTornar = new Button("Tornar");
        btnTornar.setOnAction(e ->
            screenManager.setPantalla(new PantallaTaller(taller, screenManager).getView())
        );

        root.getChildren().addAll(titol, llistaCotxes, btnTornar);
        return root;
    }
}
