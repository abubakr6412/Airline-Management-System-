package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;
import java.util.Scanner;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class menu implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private AnchorPane pane1;
	
	@FXML
	private AnchorPane pane2;
	
	@FXML
	private AnchorPane pane3;
	
	@FXML
	private Label id1;
	
	@FXML
	private Button viewflights;
	
	 @FXML
	 private VBox pnItems = null;
	 
	 @FXML
	 private ImageView image;
	 @FXML
	 private Text txt;
	 @FXML
	 private ImageView image1;
	 @FXML
	 private Text txt1;
	 
	 @FXML
		TableView<menushow> tableView = new TableView<menushow>();
		@FXML
		TableColumn<menushow, String> Companyname = new TableColumn<>();
		@FXML
		TableColumn<menushow, String> airport = new TableColumn<>();
		@FXML
		TableColumn<menushow, String> origin = new TableColumn<>();
		@FXML
		TableColumn<menushow, String> destination = new TableColumn<>();
		@FXML
		TableColumn<menushow, String> status = new TableColumn<>();

		@FXML
		TextField rem = new TextField();

	

	
	public void translateAnimation(double duration, Node node, double width) {
		TranslateTransition translatetransition = new TranslateTransition(Duration.seconds(duration), node);
		translatetransition.setByX(width);
		translatetransition.play();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id1.setText("ID: " + Integer.toString(tempStatic.LoginID));
		translateAnimation(0.5,pane2,851);
		translateAnimation(0.5,pane3,851);
		image.setVisible(false);
		txt.setVisible(false);
		image1.setVisible(false);
		txt1.setVisible(false);
		
		Companyname.setCellValueFactory(new PropertyValueFactory<>("Companyname"));
		airport.setCellValueFactory(new PropertyValueFactory<>("airport"));
		origin.setCellValueFactory(new PropertyValueFactory<>("origin"));
		destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		tableView.getColumns().clear();
		tableView.getColumns().add(Companyname);
		tableView.getColumns().add(airport);
		tableView.getColumns().add(origin);
		tableView.getColumns().add(destination);
		tableView.getColumns().add(status);
		
		for(int i = 0; i < ARS.getInstance().menushow_list.size(); i++)
		{
			String[] stringarray = ARS.getInstance().menushow_list.get(i).Displaymenushow().split("\n");
			for (int j = 0; j < stringarray.length; j++) {
				
					String[] tokens = stringarray[j].split(",");
					tableView.getItems().add(new menushow(tokens[0], tokens[1],tokens[2], tokens[3], tokens[4]));
				}
		}
		
		for(int i = 0; i < ARS.getInstance().Customer_list.size(); i++)
		{
			if (tempStatic.notify == true && tempStatic.notifyid ==  ARS.getInstance().Customer_list.get(i).getCustomer_ID()){
				image.setVisible(true);
				txt.setVisible(true);
			}
			
		}
		if (tempStatic.confirmation == true){
			image1.setVisible(true);
			txt1.setVisible(true);
		}
		
		
		
		
	}

	
	int show = 0;
	@FXML
	void next(MouseEvent event) {
		if(show == 0)
		{
			translateAnimation(0.5,pane2,-851);
			show++;
		}
		else if(show == 1)
		{
			translateAnimation(0.5,pane3,-851);
			show++;
		}
	}
	
	@FXML
	void back(MouseEvent event) {
		if(show == 1)
		{
			translateAnimation(0.5,pane2,851);
			show--;
		}
		else if(show == 2)
		{
			translateAnimation(0.5,pane3,851);
			show--;
		}
	}
	
	public void switchToflightSchedule(MouseEvent event) throws IOException {
		
		tempStatic.confirmation = false;
		root = FXMLLoader.load(getClass().getResource("Flights.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
    public void switchToBookings(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("booking.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
   public void signout(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
   
   public void notification(MouseEvent event) throws IOException {
		
 		root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
 		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 		scene = new Scene(root);
 		stage.setScene(scene);
 		stage.show();
 	}
   
   public void complain(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("complain.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
   
   public void profile(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("profile.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
   
	

	
	

}
