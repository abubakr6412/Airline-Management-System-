package UI;
import application.*;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApplication extends Application implements Runnable{
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    stage = new Stage();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start.fxml"));
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		launch();
	}

	public void hide() {
		stage.hide();
	}

	
}
