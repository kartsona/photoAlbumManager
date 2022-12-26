//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * album photos controller used for interacting with album view
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class AlbumPhotosController implements Initializable {
	@FXML
    private TextField TextField;

    @FXML
    private Button addCaptionButton;

    @FXML
    private Button addNewPhotoButton;

    @FXML
    private Label albumHeader;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deletePhotoButton;

    @FXML
    private ListView<?> listview;

    @FXML
    private Button logOutButton;

    @FXML
    private Button movePhotoButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button slideShowButton;

    @FXML
    private Button viewPhotoButton;
    
    
    static Album newAlbum;
    
    private Scene scene;
    
	private Parent root;
	    
	Stage mainStage;
    
    /**
     * used to pass data between two views
     * 
     * @param mainStage
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @FXML
    public static void start(Stage mainStage) throws ClassNotFoundException, IOException {
    	//System.out.println("IN ALBUM PHOTO CONTROLLER");
    	
    	newAlbum =   (Album) mainStage.getUserData();
    	
    }
    /**
     * add caption to photo
     * @param event
     */
    @FXML
    void addCaption(ActionEvent event) {

    }
    
    /**
     * add a new photo to folder
     * 
     * @param event
     */
    @FXML
    void addNewPhoto(ActionEvent event) {
    	
    }

    /**
     * cancel 
     * @param event
     */
    @FXML
    void cancel(ActionEvent event) {

    }

    /**
     * delete photo 
     * @param event
     */
    @FXML
    void deletePhoto(ActionEvent event) {

    }

    /**
     * logout of view and go back to log in screen
     * @param event
     */
    @FXML
    void logOut(ActionEvent event) {

    }
    
    /**
     * move the photo to a different location 
     * @param event
     */
    @FXML
    void movePhoto(ActionEvent event) {

    }

    /**
     * save photo to album 
     * @param event
     */
    @FXML
    void save(ActionEvent event) {

    }
    
    /**
     * link to slide show view 
     * @param event
     */
    @FXML
    void slideShow(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/view/SlideShow.fxml"));
		
		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		//mainStage.setUserData(goToAlbum);
		//mainStage.setUserData(user);
		
		SlideShowController.start(mainStage);	
		mainStage.setTitle("'s Photos");
		scene = new Scene(root);
		mainStage.setScene(scene);
    	
    }

    /**
     * view the photo 
     * @param event
     */
    @FXML
    void viewPhoto(ActionEvent event) {

    }

    /**
     * initialize the data that is need to be used
     * @param event
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}


