package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;

import application.Flight;
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

	@SuppressWarnings("exports")
	public void updateflight(MouseEvent event) throws IOException {

		int id = 0;
		if (ID.getText() == "") {
			label.setText("ID can't be null");
		} else {
			id = Integer.parseInt(ID.getText());
		}
		Boolean check = true;

		for (int i = 0; i < ARS.getInstance().Flight_list.size(); i++) {
			if (id == ARS.getInstance().Flight_list.get(i).getFlightID()) {
				check = false;

			}
		}

		if (check == true) {

			label.setText("Flight ID incorrect");
		} else {

			if (source.getText() == "" && dest.getText() == "" && date.getText() == "" && price.getText() == ""
					&& cap.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), 0, "", "", "", "", depart.getText(),
						arrival.getText(), "");
			} else if (arrival.getText() == "" && depart.getText() == "" && date.getText() == ""
					&& price.getText() == "" && cap.getText() == "" && dest.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), 0, source.getText(), "", "", "", "", "","");

			} else if (arrival.getText() == "" && depart.getText() == "" && date.getText() == ""
					&& price.getText() == "" && cap.getText() == "" && source.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), 0, "", dest.getText(), "", "", "", "", "");

			} else if (arrival.getText() == "" && depart.getText() == "" && date.getText() == ""
					&& price.getText() == "" && cap.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), 0, source.getText(), dest.getText(), "",
						"", "", "", "");

			}

			else if (depart.getText() == "" && arrival.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", date.getText(), depart.getText(), arrival.getText(), "");
			}

			else if (source.getText() == "" && dest.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", date.getText(), depart.getText(), arrival.getText(), "");
			} else if (cap.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), 0, source.getText(), dest.getText(), "",
						date.getText(), depart.getText(), arrival.getText(), price.getText());

			} else if (source.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()), "",
						dest.getText(), "", date.getText(), depart.getText(), arrival.getText(), price.getText());
			} else if (dest.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), "", "", date.getText(), depart.getText(), arrival.getText(), price.getText());
			}

			else if (date.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", "", depart.getText(), arrival.getText(), price.getText());
			}

			else if (depart.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", date.getText(), "", arrival.getText(), price.getText());
			}

			else if (arrival.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", date.getText(), depart.getText(), "", price.getText());
			} else if (price.getText() == "") {

				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", date.getText(), depart.getText(), arrival.getText(), "");
			} else {
				ARS.getInstance().EditFlight(Integer.parseInt(ID.getText()), Integer.parseInt(cap.getText()),
						source.getText(), dest.getText(), "", date.getText(), depart.getText(), arrival.getText(),
						price.getText());

			}
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

	public void logout(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void about(MouseEvent event) throws IOException {

		tempStatic.back = "Updateflights.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "Updateflights.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}