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

public class adminbookings implements Initializable {

	@FXML
	TableView<Booking> tableView = new TableView<Booking>();
	@FXML
	TableColumn<Booking, Integer> Booking_ID = new TableColumn<>();
	@FXML
	TableColumn<Booking, Integer> Customer_ID = new TableColumn<>();
	@FXML
	TableColumn<Booking, Integer> Flight_ID = new TableColumn<>();
	@FXML
	TableColumn<Booking, Integer> Num_Seats = new TableColumn<>();

	@FXML
	TextField rem = new TextField();

	@FXML
	Label invalid = new Label();

	private Stage stage;
	private Scene scene;
	private Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Booking_ID.setCellValueFactory(new PropertyValueFactory<>("Booking_ID"));
		Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
		Flight_ID.setCellValueFactory(new PropertyValueFactory<>("Flight_ID"));
		Num_Seats.setCellValueFactory(new PropertyValueFactory<>("Num_Seats"));

		tableView.getColumns().clear();
		tableView.getColumns().add(Booking_ID);
		tableView.getColumns().add(Customer_ID);
		tableView.getColumns().add(Flight_ID);
		tableView.getColumns().add(Num_Seats);
		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {
			String[] stringarray = ARS.getInstance().Booking_list.get(i).string_Booking().split("\n");
			for (int j = 0; j < stringarray.length; j++) {

				String[] tokens = stringarray[j].split(",");
				tableView.getItems().add(new Booking(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
						Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
			}
		}
	}

	public void switchToHome(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("adminMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void search(MouseEvent event) throws IOException {

		Boolean check = true;
		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {

			if (Integer.parseInt(rem.getText()) != ARS.getInstance().Booking_list.get(i).getCustomer_ID()) {
				invalid.setText("Customer ID not Found!");
				check = false;
			}
		}

		if (check == true) {
			Booking_ID.setCellValueFactory(new PropertyValueFactory<>("Booking_ID"));
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
			Flight_ID.setCellValueFactory(new PropertyValueFactory<>("Flight_ID"));
			Num_Seats.setCellValueFactory(new PropertyValueFactory<>("Num_Seats"));

			tableView.getColumns().clear();
			tableView.getColumns().add(Booking_ID);
			tableView.getColumns().add(Customer_ID);
			tableView.getColumns().add(Flight_ID);
			tableView.getColumns().add(Num_Seats);
			for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {
				String[] stringarray = ARS.getInstance().Booking_list.get(i).string_Booking().split("\n");
				for (int j = 0; j < stringarray.length; j++) {

					String[] tokens = stringarray[j].split(",");
					if (Integer.parseInt(tokens[1]) == ARS.getInstance().Booking_list.get(i).getCustomer_ID()) {
						tableView.getItems().add(new Booking(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
								Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
					}

				}
			}
			
			root = FXMLLoader.load(getClass().getResource("adminbookings.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		
	}

}
