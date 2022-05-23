package application;

import UI.Login;
import javafx.embed.swing.JFXPanel;

public class Main {

	public static void main(String[] args) {

		ARS.getInstance().Populate();

		new JFXPanel();

		Login LoginWindow = new Login();
		LoginWindow.run();

	}

}
