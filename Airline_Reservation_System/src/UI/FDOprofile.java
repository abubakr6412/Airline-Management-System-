package UI;

import java.io.IOException;
import java.net.URL;
import application.ARS;
import application.tempStatic;
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

public class FDOprofile implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label name;
	@FXML
	private Label age;
	@FXML
	private Label number;
	@FXML
	private Label gender;
	@FXML
	private Label address;
	@FXML
	private Label id;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for(int i = 0; i < ARS.getInstance().FDO_list.size(); i++) {
			if(ARS.getInstance().FDO_list.get(i).getFDO_ID() == tempStatic.LoginID) {
				name.setText(ARS.getInstance().FDO_list.get(i).getName());
				age.setText(Integer.toString(ARS.getInstance().FDO_list.get(i).getAge()));
				number.setText(ARS.getInstance().FDO_list.get(i).getPhone());
				gender.setText(ARS.getInstance().FDO_list.get(i).getGender());
				id.setText(Integer.toString(ARS.getInstance().FDO_list.get(i).getFDO_ID()));
				address.setText(ARS.getInstance().FDO_list.get(i).getAddress());
			}
		}
		
	}
 
	public void switchToHome(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("FDOmenu.fxml"));
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

		tempStatic.back = "FDOprofile.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "FDOprofile.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

