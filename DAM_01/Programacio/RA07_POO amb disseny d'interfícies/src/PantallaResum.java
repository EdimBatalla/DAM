import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.*;
import java.util.stream.Collectors;

public class PantallaResum {
    private Taller taller;
    private ScreenManager screenManager;

    public PantallaResum(Taller taller, ScreenManager screenManager) {
        this.taller = taller;
        this.screenManager = screenManager;
    }

    public Parent getView() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(15));

        Label titol = new Label("Resum del Taller");

        // Estadístiques
        int totalClients = taller.getClients().size();
        int totalCotxes = taller.getClients().stream()
                .mapToInt(c -> c.getCotxes().size()).sum();

        Label clientsLabel = new Label("Total de clients: " + totalClients);
        Label cotxesLabel = new Label("Total de cotxes: " + totalCotxes);

        // Reparacions de tots els cotxes
        List<Reparacio> totes = new ArrayList<>();
        for (Client c : taller.getClients()) {
            for (Cotxe co : c.getCotxes()) {
                totes.addAll(co.getReparacions());
            }
        }

        //  Ordenar de més nova a més antiga
        totes.sort((r1, r2) -> r2.getData().compareTo(r1.getData()));

        // Separar per estat
        List<Reparacio> pendents = filtrarPerEstat(totes, "pendent");
        List<Reparacio> enReparacio = filtrarPerEstat(totes, "en reparació");
        List<Reparacio> finalitzades = filtrarPerEstat(totes, "finalitzada");

        ListView<String> llistaPendents = crearListView(pendents, "Pendents");
        ListView<String> llistaReparant = crearListView(enReparacio, "En reparació");
        ListView<String> llistaFinalitzades = crearListView(finalitzades, "Finalitzades");

        Button btnTornar = new Button("Tornar");
        btnTornar.setOnAction(e ->
            screenManager.setPantalla(new PantallaTaller(taller, screenManager).getView())
        );

        root.getChildren().addAll(
            titol,
            clientsLabel,
            cotxesLabel,
            new Label("Llistes de reparacions (ordenades per data):"),
            llistaPendents,
            llistaReparant,
            llistaFinalitzades,
            btnTornar
        );

        return root;
    }

    private List<Reparacio> filtrarPerEstat(List<Reparacio> llista, String estat) {
        return llista.stream()
                .filter(r -> r.getEstat().equals(estat))
                .collect(Collectors.toList());
    }

    private ListView<String> crearListView(List<Reparacio> reparacions, String titol) {
        ListView<String> vista = new ListView<>();
        vista.getItems().add(titol + " (" + reparacions.size() + ")");
        vista.getItems().addAll(reparacions.stream().map(Reparacio::toString).toList());
        return vista;
    }
}
