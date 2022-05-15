module Airline_Reservation_System {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.swing;
	requires transitive java.compiler;
	requires junit;
	exports UI;
	
	opens application to javafx.graphics, javafx.controls, javafx.fxml,javafx.base;
	opens UI to javafx.graphics, javafx.controls, javafx.fxml,javafx.base;
	
}
