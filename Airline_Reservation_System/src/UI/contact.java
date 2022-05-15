package UI;

import java.io.IOException;
import application.ARS;
import application.tempStatic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class contact {
    
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void back(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource(tempStatic.back));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
