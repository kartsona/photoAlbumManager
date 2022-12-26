//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


/**
 * contorller for user album
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class UserAlbumController implements Initializable,  Serializable{
	@FXML
    private Label albumHeader;

    @FXML
    private Button createNewAlbumButton;

    @FXML
    private Button deleteAlbumButton;

//    @FXML
//    private ListView<Photo> listview;

    @FXML
    private Button logOutButton;

    @FXML
    private Button openAlbumButton;

    @FXML
    private Button renameAlbumButton;
    
    
    


 
    
    private Scene scene;
    
    private Parent root;
    
    Stage mainStage;
    
    //Photo newUser;
    
    
    @FXML
    public static ObservableList<ImageView> ob = FXCollections.observableArrayList();
    
//    @FXML
//    public static  ObservableList<Photo> obsList;
    
    @FXML
    public static  ObservableList<Album> obsList = FXCollections.observableArrayList();
    
    @FXML
    public  ListView<Album> listview = new ListView<Album>();
    
    
    
    
    @FXML
    public  ListView<Photo> userListView;
    
//    @FXML
//    ListView<Photo> listview = new ListView<Photo>();
    
//    @FXML
//    ListView listview = new ListView();
    
    
    
    ObservableList<Photo> items = FXCollections.observableArrayList();
    
    ObservableList<ImageView> other;
    
    static User newUser; 
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button cancelButton;
    
    @FXML
    private TextField TextField;
    
//    @FXML
//    public static ArrayList<User> users = new ArrayList<User>();
    
    //static Photo user = new Photo();
    
//    
    
    
//    listview.setItems(items);
    
    
    
    
    
    
    /**
     * start method for passing data between views
     * 
     * @param mainStage
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @FXML
    public static void start(Stage mainStage) throws ClassNotFoundException, IOException {
    	
    	//obsList =  (ObservableList<Photo>) mainStage.getUserData();
    	Serialization.deserializer();
    	newUser =   (User) mainStage.getUserData();
    	
    	//System.out.println("In User Album password: " + newUser.password);
    	//System.out.println("In User Album user.name start: " + newUser.name);
    	
    	//user = (Photo) mainStage.getUserData();
    	
    	//System.out.println("In User Album user.nme start: " + newUser.password);
    	
    	//System.out.println("In User Album obsList start: " + obsList);
    	
    	if(newUser.albums == null) {
    		newUser.albums = new ArrayList<Album>();
    	}
    	
    	
    	for(Album album : newUser.albums) {
    		obsList.add(album);
    	}
    	//user = (Photo) mainStage.getUserData();
    	
    	//System.out.println("In User Album user.nme start: " + user.name);
    	
    	//System.out.println("In User Album obsList start: " + obsList);
    	
    	
    }
    
    /**
     * create album button; when pressed this creates an album
     * @param event
     */
    @FXML
    void createNewAlbum(ActionEvent event) {
    	
        TextField.setVisible(true);
        saveButton.setVisible(true);
        cancelButton.setVisible(true);

        deleteAlbumButton.setDisable(true);
        openAlbumButton.setDisable(true);
        renameAlbumButton.setDisable(true);
        
        
        
        
        
        //System.out.println(newUser.name);
	
    }
    
    
    
    /**
     * delete the album that is being requested
     * @param event
     */
    @FXML
    void deleteAlbum(ActionEvent event) {

    }
    
    /**
     * logout to the login screen 
     * @param event
     * @throws IOException
     */
    @FXML
    void logOut(ActionEvent event) throws IOException {
    	
    	//System.out.println("Amount of folder: " + user.getNumberOfFolders());
    	
    	//System.out.println("In USER Album: " + obsList);
    	Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage.setUserData(obsList);
		
		LoginController.start(mainStage);
		mainStage.setTitle("Login Screen");
		
		
		
		
		mainStage.setUserData(obsList);
		scene = new Scene(root);
		mainStage.setScene(scene);
		
		//System.out.println("In USER Album: " + obsList);
    }

    
    /**
     * open the album that is being selected by user
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    void openAlbum(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	
    		Album goToAlbum = listview.getSelectionModel().getSelectedItem();
        	
        	if(goToAlbum == null) {
        		
        	}else {
        		Parent root = FXMLLoader.load(getClass().getResource("/view/AlbumPhotos.fxml"));
        		
        		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        		mainStage.setUserData(goToAlbum);
        		//mainStage.setUserData(user);
        		
        		AlbumPhotosController.start(mainStage);	
        		mainStage.setTitle(goToAlbum.albumName + "'s Photos");
        		scene = new Scene(root);
        		mainStage.setScene(scene);
        	}
        	
    		
    	
    	
    	
    }

    /**
     * rename the album to something else 
     * @param event
     */
    @FXML
    void renameAlbum(ActionEvent event) {
    	 TextField.setVisible(true);
         saveButton.setVisible(true);
         cancelButton.setVisible(true);

         deleteAlbumButton.setDisable(true);
         openAlbumButton.setDisable(true);
         createNewAlbumButton.setDisable(true);
         
    	
    	Album renameAlbum = listview.getSelectionModel().getSelectedItem(); 
		int index = listview.getSelectionModel().getSelectedIndex();
		
		renameAlbum.changeName(TextField.getText());
		
		//TextField.getText()

    }
    
    /**
     * save button to save that data that is requesting 
     * @param event
     */
    @FXML
    void save(ActionEvent event) {
    	
    	
    	
    	Album temp = new Album(TextField.getText());
    	newUser.albums.add(temp);
    	
    	
    	obsList.add(temp);
    	listview.setItems(obsList);
    	
    	TextField.setText("");
    	
    	TextField.setVisible(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);

        deleteAlbumButton.setDisable(false);
        openAlbumButton.setDisable(false);
        createNewAlbumButton.setDisable(false);
        renameAlbumButton.setDisable(false);
        
        listview.getSelectionModel().select(0);

    }
    
    /**
     * cancel to go back
     * 
     * @param event
     */
    @FXML
    void cancel(ActionEvent event) {
    	TextField.setText("");
    	TextField.setVisible(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        
        deleteAlbumButton.setDisable(false);
        openAlbumButton.setDisable(false);
        renameAlbumButton.setDisable(false);
        createNewAlbumButton.setDisable(false);
    

    }


    
    /**
     * used to initialize data at start of program 
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		
//		try {
//			Serialization.users = Serialization.deserializer();
//		} catch (ClassNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			
//			//e.printStackTrace();
//		}
//		
//
//			obsList = FXCollections.observableArrayList();
//
//		
//		for(User user: Serialization.users) {
//			System.out.println("IN INITIALIZE: "+ user.name);
//    		obsList.add(user);
//    		
//    		
//    	}
        
        

	}
	
	
	

}


///////////////////////////////////////






