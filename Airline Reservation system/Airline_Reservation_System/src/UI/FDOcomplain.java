package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;

import application.Complain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FDOcomplain implements Initializable {
 
	@FXML
	private Rectangle box;
	@FXML
	private ImageView image;
	@FXML
	private Text txt;

	@FXML
	private TextField rem;
	@FXML
	private Label invalid;

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Complain> tableView = new TableView<Complain>();
	@FXML
	TableColumn<Complain, Integer> ComplainID = new TableColumn<>();
	@FXML
	TableColumn<Complain, String> complain = new TableColumn<>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ComplainID.setCellValueFactory(new PropertyValueFactory<>("ComplainID"));
		complain.setCellValueFactory(new PropertyValueFactory<>("complain"));
		

		tableView.getColumns().clear();
		tableView.getColumns().add(ComplainID);
		tableView.getColumns().add(complain);
		
		for (int i = 0; i < ARS.getInstance().Complain_list.size(); i++) {
			String[] stringarray = ARS.getInstance().Complain_list.get(i).string_complain().split("\n");
			for (int j = 0; j < stringarray.length; j++) {

				String[] tokens = stringarray[j].split(",");
					tableView.getItems().add(new Complain(Integer.parseInt(tokens[0]),tokens[1]));
				
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

		tempStatic.back = "FDOcomplain.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "FDOcomplain.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
}
