
//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//


package view;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Edits the album
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class AlbumEditController {
	 @FXML
	    private Button addNewPhoto;

	    @FXML
	    private ImageView backButton;

	    @FXML
	    private Button deletePhoto;

	    @FXML
	    private Button editAlbum;

	    @FXML
	    private Button editCaption;

	    @FXML
	    private ListView<?> listViewAlbum;

	    @FXML
	    private Button logOut;

	    @FXML
	    private Button movePhoto;

	    @FXML
	    private Button slideShow;

	    @FXML
	    private Button viewPhoto;
	    
	    /**
	     * backbutton for going back to album
	     * 
	     * @param event
	     */
	    @FXML
	    void backButton(MouseEvent event) {

	    }
}


