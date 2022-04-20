package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Notification implements Initializable {
	
	@FXML
	private Label label;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
			label.setText(Integer.toString(tempStatic.cancel_ID));
			tempStatic.notify = false;
		
	}
	
public void switchToHome(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
