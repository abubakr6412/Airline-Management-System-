package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;

import application.Flight;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

public class flight_schedule implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	 @FXML
		TableView<Flight> tableView = new TableView<Flight>();
		@FXML
		TableColumn<Flight, Integer> FlightID = new TableColumn<>();
		@FXML
		TableColumn<Flight, Integer> capacity = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Plane_Type = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Source = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Destination = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Flight_Date = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Departure_Time = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Arrival_Time = new TableColumn<>();
		@FXML
		TableColumn<Flight, String> Price = new TableColumn<>();

		@FXML
		TextField rem = new TextField();
		@FXML
		TextField seat = new TextField();
		
		@FXML
		Label check  = new Label();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

     
		FlightID.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
		capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		Plane_Type.setCellValueFactory(new PropertyValueFactory<>("Plane_Type"));
		Source.setCellValueFactory(new PropertyValueFactory<>("Source"));
		Destination.setCellValueFactory(new PropertyValueFactory<>("Destination"));
		Flight_Date.setCellValueFactory(new PropertyValueFactory<>("Flight_Date"));
		Departure_Time.setCellValueFactory(new PropertyValueFactory<>("Departure_Time"));
		Arrival_Time.setCellValueFactory(new PropertyValueFactory<>("Arrival_Time"));
		Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
		
		tableView.getColumns().clear();
		tableView.getColumns().add(FlightID);
		tableView.getColumns().add(capacity);
		tableView.getColumns().add(Plane_Type);
		tableView.getColumns().add(Source);
		tableView.getColumns().add(Destination);
		tableView.getColumns().add(Flight_Date);
		tableView.getColumns().add(Departure_Time);
		tableView.getColumns().add(Arrival_Time);
		tableView.getColumns().add(Price);
		for(int i = 0; i < ARS.getInstance().Flight_list.size(); i++)
		{
			String[] stringarray = ARS.getInstance().Flight_list.get(i).displayFlights().split("\n");
			for (int j = 0; j < stringarray.length; j++) {
				
					String[] tokens = stringarray[j].split(",");
					tableView.getItems().add(new Flight(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),tokens[2], tokens[3], tokens[4],tokens[5],tokens[6],tokens[7],tokens[8]));
				}
			}
		}
	
	

	
	public void switchToHome(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switchToViewbooking(MouseEvent event) throws IOException {
		
		int book = Integer.parseInt(rem.getText());
		int seat_num = Integer.parseInt(seat.getText());
		tempStatic.flightID = book;
		tempStatic.seat = seat_num;
		Boolean t2 = false;
		Boolean num = true;
		Boolean bookid = true;
		

		for(int i = 0; i < ARS.getInstance().Flight_list.size(); i++)
		{
		    if(book == ARS.getInstance().Flight_list.get(i).getFlightID()) {
		    	t2 = true;
		    }
		}
		
		for(int i = 0; i < ARS.getInstance().Flight_list.size(); i++)
		{
		    if(seat_num > ARS.getInstance().Flight_list.get(i).getCapacity() || seat_num == 0) {
		    	num = false;
		    }
		}
		

		for(int i = 0; i < ARS.getInstance().Booking_list.size(); i++)
		{
		    if(seat_num == ARS.getInstance().Booking_list.get(i).getNum_Seats() && ARS.getInstance().Booking_list.get(i).getFlight_ID() == book) {
		    	bookid = false;
		    }
		}
		if(t2 == false) {
			check.setText("ID Not Found");
		}
		else if (num == false) {
			check.setText("Seat does not exist");
		}
		else if (bookid == false) {
			check.setText("Seat Already Booked");
		}
		
		if(t2 == true && num == true && bookid == true) {
		for(int i = 0; i < ARS.getInstance().Flight_list.size(); i++)
		{
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Islamabad")) {
		        root = FXMLLoader.load(getClass().getResource("bookticket.fxml"));
		        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			}
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Karachi")) {
		        root = FXMLLoader.load(getClass().getResource("Karachi.fxml"));
		        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			}
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Multan")) {
		        root = FXMLLoader.load(getClass().getResource("multan.fxml"));
		        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			}
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Lahore")) {
		        root = FXMLLoader.load(getClass().getResource("Lahore.fxml"));
		        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			}
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Faisalabad")) {
		        root = FXMLLoader.load(getClass().getResource("Faisalabad.fxml"));
		        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			}
			if(tempStatic.flightID == ARS.getInstance().Flight_list.get(i).getFlightID() && ARS.getInstance().Flight_list.get(i).getDestination().equals("Peshawer")) {
		        root = FXMLLoader.load(getClass().getResource("Peshawar.fxml"));
		        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			}
			
		}
	}
	}

	public void logout(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void about(MouseEvent event) throws IOException {

		tempStatic.back = "Flights.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "Flights.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
