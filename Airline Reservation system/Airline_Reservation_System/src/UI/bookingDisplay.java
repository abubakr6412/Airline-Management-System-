package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.ARS;
import application.tempStatic;

import application.Booking;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class bookingDisplay implements Initializable {

	@FXML
	private Rectangle box;
	@FXML
	private ImageView image;
	@FXML
	private Text txt;
	
	@FXML
	private Rectangle box1;
	@FXML
	private ImageView image1;
	@FXML
	private PasswordField pin;
	@FXML
	private Text txt1;
	@FXML
	private Button next;

	@FXML
	private TextField rem;
	@FXML
	private Label invalid;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	 private ImageView myImage;
	@FXML
	private Rectangle box2;
	@FXML
	private Text txt2;
	@FXML
	private Button Ok;
	 

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

		box.setVisible(false);
		image.setVisible(false);
		txt.setVisible(false);
		box1.setVisible(false);
		image1.setVisible(false);
		txt1.setVisible(false);
		next.setVisible(false);
		pin.setVisible(false);
		box2.setVisible(false);
		myImage.setVisible(false);
        txt2.setVisible(false);
        Ok.setVisible(false);
        
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

			if (ARS.getInstance().Booking_list.get(i).getCustomer_ID() == tempStatic.LoginID) {
				String[] stringarray = ARS.getInstance().Booking_list.get(i).string_Booking().split("\n");
				for (int j = 0; j < stringarray.length; j++) {

					String[] tokens = stringarray[j].split(",");
					tableView.getItems().add(new Booking(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),tokens[4]));
				}
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

	public void cancel(MouseEvent event) throws IOException {

		Boolean check = true;
		int id = Integer.parseInt(rem.getText());
		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {

			if (id == ARS.getInstance().Booking_list.get(i).getBooking_ID()) {
				box.setVisible(true);
				image.setVisible(true);
				txt.setVisible(true);
				tempStatic.cancel_ID = Integer.parseInt(rem.getText());
				check = false;
			}
		}
		if (check == true) {
			invalid.setText("Booking ID not Found!");
		}

		
	}
    
	public void payment(MouseEvent event) throws IOException {
		
		Boolean check = true;
		int id = Integer.parseInt(rem.getText());
		for (int i = 0; i < ARS.getInstance().Booking_list.size(); i++) {

			if (id == ARS.getInstance().Booking_list.get(i).getBooking_ID()) {
				box1.setVisible(true); image1.setVisible(true); txt1.setVisible(true);
				next.setVisible(true); pin.setVisible(true);
				check = false;
			}
		}
		if (check == true) {
			invalid.setText("Booking ID not Found!");
		}
		
	}
	
	public void next(MouseEvent event) throws IOException {
		
		  
		  myImage.setVisible(true);
          box2.setVisible(true);
		  RotateTransition rotate = new RotateTransition();
		  rotate.setNode(myImage);
		  rotate.setDuration(Duration.millis(1000));
		  rotate.setCycleCount(3);
		  rotate.setInterpolator(Interpolator.LINEAR);
		  rotate.setByAngle(360);
		  rotate.setAxis(Rotate.Z_AXIS);
		  rotate.play();
		  
		  rotate.setOnFinished((finish) -> {
		        txt2.setVisible(true);
		        Ok.setVisible(true);
		        myImage.setVisible(false);
		      });
		
	}
	

	
	public void Ok(MouseEvent event) throws IOException {
		
		
		tempStatic.cancel_ID = Integer.parseInt(rem.getText());
		root = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void cross(MouseEvent event) throws IOException {

		box.setVisible(false);
		image.setVisible(false);
		txt.setVisible(false);
		box1.setVisible(false); 
		image1.setVisible(false);
		txt1.setVisible(false);
		next.setVisible(false);
		pin.setVisible(false);
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

		tempStatic.back = "booking.fxml";
		root = FXMLLoader.load(getClass().getResource("about.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void contact(MouseEvent event) throws IOException {

		tempStatic.back = "booking.fxml";
		root = FXMLLoader.load(getClass().getResource("contact.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
