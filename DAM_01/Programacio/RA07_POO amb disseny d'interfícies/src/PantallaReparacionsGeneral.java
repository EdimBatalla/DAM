import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class PantallaReparacionsGeneral {
    private Taller taller;
    private ScreenManager screenManager;

    public PantallaReparacionsGeneral(Taller taller, ScreenManager screenManager) {
        this.taller = taller;
        this.screenManager = screenManager;
    }

    public Parent getView() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label titol = new Label("Reparacions de tots els cotxes:");
        ListView<String> llistaReparacions = new ListView<>();

        for (Client c : taller.getClients()) {
            for (Cotxe co : c.getCotxes()) {
                for (Reparacio r : co.getReparacions()) {
                    String entrada = c.getNom() + " • " + co.getMatricula() + " → " + r.toString();
                    llistaReparacions.getItems().add(entrada);
                }
            }
        }

        Button btnTornar = new Button("Tornar");
        btnTornar.setOnAction(e ->
            screenManager.setPantalla(new PantallaTaller(taller, screenManager).getView())
        );

        root.getChildren().addAll(titol, llistaReparacions, btnTornar);
        return root;
    }
}
