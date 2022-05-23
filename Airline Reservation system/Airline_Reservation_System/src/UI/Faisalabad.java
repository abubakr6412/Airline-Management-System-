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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Faisalabad implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label arrival = new Label();
	@FXML
	private Label depart = new Label();
	@FXML
	private Label city = new Label();
	@FXML
	private Label dest  = new Label();
	@FXML
	private Label seat = new Label();
	@FXML
	private Label orig = new Label();
	@FXML
	private Label stype  = new Label();
	@FXML
	private Label price  = new Label();
	
	@FXML
	Rectangle shape = new Rectangle();
	
	@FXML
	Text text = new Text();
	
	@FXML
	Button button = new Button();
	
	@FXML
	Button back = new Button();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		shape.setVisible(false);
		text.setVisible(false);
		button.setVisible(false);;
		
		for(int i = 0; i < ARS.getInstance().Flight_list.size(); i++)
		{
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Faisalabad")) {
				
				arrival.setText(ARS.getInstance().Flight_list.get(i).getArrival_Time());
				depart.setText(ARS.getInstance().Flight_list.get(i).getDeparture_Time());
				city.setText(ARS.getInstance().Flight_list.get(i).getDestination());
				dest.setText(ARS.getInstance().Flight_list.get(i).getDestination());
				price.setText(ARS.getInstance().Flight_list.get(i).getPrice());
				orig.setText(ARS.getInstance().Flight_list.get(i).getSource());
			     
			}
		}
		
		seat.setText(Integer.toString(tempStatic.seat));
		if(tempStatic.seat > 0 &&  tempStatic.seat < 51) {
			stype.setText("Business");
		}
		else {
			stype.setText("Economy");
		}
		
	}

	
	public void switchToHome(MouseEvent event) throws IOException {
		
		
		root = FXMLLoader.load(getClass().getResource("Flights.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Okaymessage(MouseEvent event) throws IOException {
		
		int bid = 0;
		int seat = 0;

		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {
			bid = ARS.getInstance().Booking_list.get(i).getBooking_ID();
		}

		bid = bid + 1;
		if(tempStatic.seat > 0 &&  tempStatic.seat < 51) {
			ARS.getInstance().AddBooking(bid, tempStatic.LoginID, tempStatic.seat, tempStatic.flightID,"Business");
		}
		else {
			ARS.getInstance().AddBooking(bid, tempStatic.LoginID, tempStatic.seat, tempStatic.flightID,"Economy");
		}
				   
	    shape.setVisible(true);
		text.setVisible(true);
		button.setVisible(true);
		back.setVisible(false);
		
	}
   
   public void switchToHomeS(MouseEvent event) throws IOException {
		
		
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
