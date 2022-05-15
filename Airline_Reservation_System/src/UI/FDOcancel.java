package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;

import application.Booking;
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

public class FDOcancel implements Initializable {

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
	TableColumn<Booking, String> Seattype = new TableColumn<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Booking_ID.setCellValueFactory(new PropertyValueFactory<>("Booking_ID"));
		Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
		Flight_ID.setCellValueFactory(new PropertyValueFactory<>("Flight_ID"));
		Num_Seats.setCellValueFactory(new PropertyValueFactory<>("Num_Seats"));
		Seattype.setCellValueFactory(new PropertyValueFactory<>("Seattype"));
		
		tableView.getColumns().clear();
		tableView.getColumns().add(Booking_ID);
		tableView.getColumns().add(Customer_ID);
		tableView.getColumns().add(Flight_ID);
		tableView.getColumns().add(Num_Seats);
		tableView.getColumns().add(Seattype);
		
		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {
			String[] stringarray = ARS.getInstance().Booking_list.get(i).string_Booking().split("\n");
			for (int j = 0; j < stringarray.length; j++) {

				String[] tokens = stringarray[j].split(",");
				if (Integer.parseInt(tokens[0]) == tempStatic.cancel_ID) {
					tableView.getItems().add(new Booking(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),tokens[4]));
				}
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

	public void cancel(MouseEvent event) throws IOException {

		Boolean check = true;
		
        for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {
        	if(Integer.parseInt(rem.getText()) == ARS.getInstance().Booking_list.get(i).getBooking_ID()) {
        	    tempStatic.notify = true;
        	    tempStatic.notifyid = ARS.getInstance().Booking_list.get(i).getCustomer_ID();
        	    ARS.getInstance().CancelBooking(Integer.parseInt(rem.getText()));
        		invalid.setText("Booking Cancelled.");
        		check = false;
        	}
        	
        }
		
        if(check == true) {
        	invalid.setText("Booking ID does not exist.");
        }
			
        
		tempStatic.cancel_ID = Integer.parseInt(rem.getText());
		rem.setText("");

	}

	public void logout(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void about(MouseEvent event) throws IOException {

		tempStatic.back = "FDOcancelbook.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "FDOcancelbook.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
