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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ticket implements Initializable {

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

	@FXML
	private Label lab1;
	@FXML
	private Label lab2;
	@FXML
	private Label lab3;
	@FXML
	private Label lab4;
	@FXML
	private Label lab5;
	@FXML
	private Label lab6;
	@FXML
	private Label lab7;
	@FXML
	private Label lab8;

	private Stage stage;
	private Scene scene;
	private Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		int flightId = 0;
		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {
			if (tempStatic.cancel_ID == ARS.getInstance().Booking_list.get(i).getBooking_ID()) {
				flightId = ARS.getInstance().Booking_list.get(i).getFlight_ID();
				lab6.setText(Integer.toString(ARS.getInstance().Booking_list.get(i).getNum_Seats()));
			}
		}

		for (int i = 0; i < ARS.getInstance().Flight_list.size(); i++) {
			if (flightId == ARS.getInstance().Flight_list.get(i).getFlightID()) {
				lab1.setText(ARS.getInstance().Flight_list.get(i).getSource());
				lab2.setText(ARS.getInstance().Flight_list.get(i).getDestination());
				lab4.setText(ARS.getInstance().Flight_list.get(i).getFlight_Date());
				lab5.setText(ARS.getInstance().Flight_list.get(i).getPlane_Type());
				lab7.setText(ARS.getInstance().Flight_list.get(i).getDeparture_Time());
			}
		}

		for (int i = 0; i < ARS.getInstance().Customer_list.size(); i++) {
			if (tempStatic.LoginID == ARS.getInstance().Customer_list.get(i).getCustomer_ID()) {
				lab3.setText(ARS.getInstance().Customer_list.get(i).getName());
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

}
