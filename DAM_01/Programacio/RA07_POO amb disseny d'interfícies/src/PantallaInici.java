import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class PantallaInici {
	private Taller taller;
	private ScreenManager screenManager;

	public PantallaInici(Taller taller, ScreenManager screenManager) {
		this.taller = taller;
		this.screenManager = screenManager;
	}

	//escena inicial
	public Parent getView() {
		VBox vbox = new VBox(20);
		vbox.setPadding(new Insets(20));
		vbox.setAlignment(Pos.CENTER);
		Button btnTaller = new Button("Gestió Taller");
		btnTaller.setOnAction(e -> {
			PantallaTaller pantallaTaller = new PantallaTaller(taller, screenManager);
			screenManager.setPantalla(pantallaTaller.getView());
		});
		vbox.getChildren().addAll(btnTaller);
		return vbox;
	}
}