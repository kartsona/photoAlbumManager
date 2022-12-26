//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//Net

package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

/**
 * Start of Photos88 application
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class SlideShowController implements Initializable{
	
	 @FXML
	 private Button goBackToAlbumButton;

	 @FXML
	 private ImageView leftArrow;

	 @FXML
	 private ImageView mainImage;

	 @FXML
	 private ImageView rightArrow;
	 
	 private Scene scene;
	    
	 private Parent root;
	    
	 Stage mainStage;
	 
	 
	 /**
	  * start method for passing data between views
	  * 
	  * @param mainStage
	  * @throws ClassNotFoundException
	  * @throws IOException
	  */
	 @FXML
	    public static void start(Stage mainStage) throws ClassNotFoundException, IOException {
	    	//System.out.println("IN Slide Show CONTROLLER");
	    	
	    	
	    	
	    }

	 /**
	  * this allow the user to go back to the album they were last at
	  * @param event
	  * @throws IOException
	  * @throws ClassNotFoundException
	  */
	 @FXML
	 void goBackToAlbum(ActionEvent event) throws IOException, ClassNotFoundException {
		
	    	
			Parent root = FXMLLoader.load(getClass().getResource("/view/AlbumPhotos.fxml"));
			
			mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			//mainStage.setUserData(goToAlbum);
			//mainStage.setUserData(user);
			
			AlbumPhotosController.start(mainStage);	
			mainStage.setTitle( "'s Photos");
			scene = new Scene(root);
			mainStage.setScene(scene);

	 }

	 /**
	  * arrow for moving left through the images slideshow
	  * @param event
	  */
	 @FXML
	 void moveLeft(MouseEvent event) {

	 }

	 /**
	  * arrow for moving right through the images slideshow
	  * @param event
	  */
	 @FXML
	 void moveRight(MouseEvent event) {
		 
	 }

	/**
	 * initializes data being either read or stored
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}





