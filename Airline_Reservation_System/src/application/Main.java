package application;

import javafx.embed.swing.JFXPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ARS.getInstance().Populate();

		new JFXPanel();

		Login LoginWindow = new Login();
		LoginWindow.run();

	}

}
