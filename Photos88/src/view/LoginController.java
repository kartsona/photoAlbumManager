//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.util.*;



import java.io.*;
import java.lang.*;
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * Login controller for dealing with with first screen the users sees
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class LoginController implements Initializable, Serializable {
	
	@FXML
    private Label ErrorLabel;

    @FXML
    private Button clearButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;
    
    
    
    private Scene scene;
    
    private Parent root;
    
    Stage mainStage;
    
    Photo newUser;
    
   // private static DataModel model;
    private static DataModel model = new DataModel();
    
    //static private  ObservableList<Photo> obsList;
    
    static private  ObservableList<User> obsList;
    
//    @FXML
//    private ListView<Photo> userListView;
    
    @FXML
    private ListView<User> userListView;
    
//    @FXML
//    public static ArrayList<User> users = new ArrayList<User>();
    
    
    
    

    /**
     * Start method for passing data between views
     * @param mainStage
     * @throws FileNotFoundException
     */
    public static void start(Stage mainStage) throws FileNotFoundException {
    	
    	
    	//obsList =  (ObservableList<Photo>) mainStage.getUserData();
    	
//    	obsList =  (ObservableList<User>) mainStage.getUserData();
//    	
//    	
//    	System.out.println("Start: " + obsList);
    	
    
    }
    
    
    /**
     * clear the user input for  log in screen
     * @param event
     */
    @FXML
    void clearUserInput(ActionEvent event) {
    	userName.setText("");
    	password.setText("");
    }

    /**
     * Used to log into to either admin view of individual views
     * 
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    void loginToUser(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	//System.out.println("IN login: " + obsList);
    	if(userName.getText().equals("admin") && password.getText().equals("")){
    		ErrorLabel.setVisible(false);
    		Parent root = FXMLLoader.load(getClass().getResource("/view/AdminSubsystem.fxml"));
    		
    		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		mainStage.setUserData(obsList);
    		//mainStage.setUserData(userListView);
    		
    		//AdminSubSystemController.getObservableListData();
    		AdminSubSystemController.start(mainStage);
    		mainStage.setTitle("Admin Screen");
    		scene = new Scene(root);
    		mainStage.setScene(scene);
    		
    		
    		mainStage = (Stage) loginButton.getScene().getWindow();
    
    		//System.out.println("ok");
    	}else {
    		if(obsList == null) {
    			obsList = FXCollections.observableArrayList();
    			
    			//obsList = (ObservableList<Photo>) mainStage.getUserData();
    			obsList = (ObservableList<User>) mainStage.getUserData();
    		}
    		
    		//System.out.println("Else statement in LoginController " + obsList);
    		if(obsList == null) {
    			//System.out.println("obsList is null in loginController line 148");
    		}
    		for(User user: obsList) {
    			if(userName.getText().equals(user.name)  && password.getText().equals(user.password)) {
    				
    				ErrorLabel.setVisible(false);
    				//System.out.println("THERE IS A MATCH");
    				Parent root = FXMLLoader.load(getClass().getResource("/view/UserAlbum.fxml"));
    	    		
    	    		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	    		//mainStage.setUserData(obsList);
    	    		mainStage.setUserData(user);
    	    		
    	    		UserAlbumController.start(mainStage);
    	    		
//    	    		
    	    		mainStage.setTitle(user.name + "'s Albums");
    	    		scene = new Scene(root);
    	    		mainStage.setScene(scene);
    	    		
    	    		
    	    		//mainStage = (Stage) loginButton.getScene().getWindow();
    		 	}

        	}
    		//System.out.println("Error");
    		userName.setText("");
        	password.setText("");
    		ErrorLabel.setVisible(true);
    	}
 	
    }

	
    
    
    
	/**
	 * used for exiting application 
	 * @throws IOException
	 */
	@FXML
    public static void exit() throws IOException {
	
    	//System.out.println("Exiting. See you later!");
 
    }


	/**
	 * Used for initializing data to be used in this controller
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		
//		if(obsList == null) {
//			obsList = FXCollections.observableArrayList();
//		}
//		
//	
//		System.out.println("Login obsList: " + obsList);
//		
//		for(User user: obsList) {
//			System.out.println("In initialize: " + user.name);
//		}
		
		try {
			Serialization.users = Serialization.deserializer();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();
		}
		

			obsList = FXCollections.observableArrayList();

		
		for(User user: Serialization.users) {
			//System.out.println("IN INITIALIZE: "+ user.name);
    		obsList.add(user);
    		
    		
    	}
		
		
		
		
		
	}



}
