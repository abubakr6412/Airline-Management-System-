package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class complaintUI implements Initializable{

	@FXML
	TextField compl;
	@FXML
	private Rectangle box;
	@FXML
	private ImageView image;
	@FXML
	private Text txt;

	@FXML
	private TextArea rem = new TextArea();
	@FXML
	private Label invalid;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		box.setVisible(false);
		image.setVisible(false);
		txt.setVisible(false);
    
	}
	

	public void save(MouseEvent event) throws IOException {
        
		int cid = 0;
		for (int i = 0; i < ARS.getInstance().Complain_list.size(); i++) {
			cid = ARS.getInstance().Complain_list.get(i).getComplainID();
			
		}
		cid = cid + 1;
		ARS.getInstance().complain(cid, rem.getText());
		box.setVisible(true);
		image.setVisible(true);
		txt.setVisible(true);
		
	}

	public void cross(MouseEvent event) throws IOException {

		box.setVisible(false);
		image.setVisible(false);
		txt.setVisible(false);
		rem.setText("");
	}

	public void switchToHome(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void logout(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void about(MouseEvent event) throws IOException {

		tempStatic.back = "complain.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "complain.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
