import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
	private Stage stage;

	public ScreenManager(Stage stage) {
		this.stage = stage;
	}

	public void setPantalla(Parent root) {
		Scene scene = new Scene(root, 800, 800);
		stage.setScene(scene);
		stage.show();
	}
}