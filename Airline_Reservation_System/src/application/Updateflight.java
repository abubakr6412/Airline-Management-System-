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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Updateflight implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TextField planetype = new TextField();
	@FXML
	TextField source = new TextField();
	@FXML
	TextField dest = new TextField();
	@FXML
	TextField depart = new TextField();
	@FXML
	TextField arrival = new TextField();
	@FXML
	TextField date = new TextField();
	@FXML
	TextField price = new TextField();
	@FXML
	TextField cap = new TextField();
	@FXML
	TextField ID = new TextField();

	@FXML
	Label label = new Label();

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
		for (int i = 0; i < ARS.getInstance().Flight_list.size(); i++) {
			String[] stringarray = ARS.getInstance().Flight_list.get(i).displayFlights().split("\n");
			for (int j = 0; j < stringarray.length; j++) {

				String[] tokens = stringarray[j].split(",");
				tableView.getItems().add(new Flight(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2],
						tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], tokens[8]));
			}
		}
	}

	public void updateflight(MouseEvent event) throws IOException {

		int id = Integer.parseInt(ID.getText());
		Boolean check = true;

		for (int i = 0; i < ARS.getInstance().Flight_list.size(); i++) {
			if (id != ARS.getInstance().Flight_list.get(i).getFlightID()) {
				label.setText("Flight ID incorrect");
				check = false;
			}
		}

		ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()), source.getText(),
				dest.getText(), null, date.getText(), depart.getText(), arrival.getText(), price.getText());

		if (check == true) {
			root = FXMLLoader.load(getClass().getResource("Updateflights.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

	}

	public void switchToHome(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
