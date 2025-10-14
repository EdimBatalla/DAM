import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
	Taller taller = new Taller();
	ScreenManager screenManager = new ScreenManager(primaryStage);
	PantallaInici pantallaInici = new PantallaInici(taller, screenManager);
	screenManager.setPantalla(pantallaInici.getView());
	primaryStage.setTitle("Entrar al Taller");
	}

	public static void main(String[] args) {
		launch(args);
	}
}