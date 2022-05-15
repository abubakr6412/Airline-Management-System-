package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Loading implements Initializable{
	
	@FXML
	 private ImageView myImage;
	@FXML
	 private Text txt;
	 
	 @Override
	 public void initialize(URL arg0, ResourceBundle arg1) {
		  
		  txt.setVisible(false);;
		  RotateTransition rotate = new RotateTransition();
		  rotate.setNode(myImage);
		  rotate.setDuration(Duration.millis(1000));
		  rotate.setCycleCount(3);
		  rotate.setInterpolator(Interpolator.LINEAR);
		  rotate.setByAngle(360);
		  rotate.setAxis(Rotate.Z_AXIS);
		  rotate.play();
		  
		  rotate.setOnFinished((finish) -> {
			  txt.setVisible(true);
		      });
	 }

}
