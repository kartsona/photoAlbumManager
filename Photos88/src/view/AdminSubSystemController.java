
//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Node;

import java.util.*;
import java.awt.desktop.UserSessionEvent;
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
import javafx.stage.Stage;
import javafx.util.BuilderFactory;

/**
 * Admin SubSystem Controller
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class AdminSubSystemController  implements Initializable, Serializable {

    @FXML
    private Button clearButton;

    @FXML
    private Button createUser;

    @FXML
    private Button deleteUser;

    @FXML
    private Button logOut;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordText;

    @FXML
    private Button saveButton;


    @FXML
    private Label userNameLabel;

    @FXML
    private TextField userNameText;
    
    @FXML
    private Label duplicateEntry;

    
  
    
    private Scene scene;
    
    private Parent root;
    
    Stage mainStage;
    
    User newUser;
    
    //Photo newUser;
    
    @FXML
    public static  ObservableList<User> obsList;
    
    
//    @FXML
//    public static ArrayList<User> users = new ArrayList<User>();
//    @FXML
//    private static  ObservableList<Photo> obsList = FXCollections.observableArrayList();
    
    @FXML
    public  ListView<User> userListView;
    
    //private DataModel model;
    
     private DataModel model = new DataModel();
    

    /**
     * start method when needing to pass data to controller
     * 
     * @param mainStage Stage that is being view
     * @throws ClassNotFoundException exception
     * @throws IOException exception
     */
    @FXML
    public static void start(Stage mainStage) throws ClassNotFoundException, IOException {
    	
//    	obsList =  (ObservableList<User>) mainStage.getUserData();
//    	
//    	for(User user: obsList) {
//    		users.add(user);
//    	}
    	
    	//users = Serialization.deserializer();
//    	
//    	for(User user: users) {
//    		obsList.add(user);
//    	}
    	
    	
    	
    	
    	
//    	obsList =  (ObservableList<Photo>) mainStage.getUserData();
//    	
//    	System.out.println("In start of AdminSubSystme: " + obsList);
    	
    	
    }
    

 

    /**
     * exit function for exiting the program
     * 
     * @throws IOException exception
     */
	@FXML
    public static void exit() throws IOException {
	
    	//System.out.println("Exiting. See you later!");
 
    }
    

    
    /**
     * Clear button when admin presses to clear input
     * 
     * @param event action event
     */
    @FXML
    void clearButton(ActionEvent event) {
    	userNameText.setText("");
    	passwordText.setText("");
    	
    	deleteUser.setVisible(true);
    	userNameLabel.setVisible(false);
    	passwordLabel.setVisible(false);
    	userNameText.setVisible(false);
    	passwordText.setVisible(false);
    	saveButton.setVisible(false);
    	clearButton.setVisible(false);
    }
    
    /**
     * create button to create a new user
     * 
     * @param event action event
     */
    @FXML
    void createUserButton(ActionEvent event) {
    	deleteUser.setVisible(false);
    	userNameLabel.setVisible(true);
    	passwordLabel.setVisible(true);
    	userNameText.setVisible(true);
    	passwordText.setVisible(true);
    	saveButton.setVisible(true);
    	clearButton.setVisible(true);
    	
    	
    }
    
    /**
     * Delete button to delete user from list
     * 
     * @param event action event
     * @throws IOException exception
     */
    @FXML
    void deleteUserButton(ActionEvent event) throws IOException {
    	if(obsList == null) {
    		//System.out.println("List Is Empty");
    		deleteUser.setDisable(true);
    	}
    	
    	if(obsList.isEmpty()) {
    		//System.out.println("List Is Empty");
    		deleteUser.setDisable(true);
    		
    	}else {
    		if(obsList.isEmpty()) {
        		//System.out.println("List Is Empty");
        		deleteUser.setDisable(true);
        		
        	}
    		User deleteUser = userListView.getSelectionModel().getSelectedItem(); 
    		int index = userListView.getSelectionModel().getSelectedIndex();
    		obsList.remove(index);
    		
    		Serialization.users.remove(deleteUser);
    		
    		Serialization.serializer();
    		
    		
    	}
    	
    	
    }

    /**
     * Log out button from admin subsystem back to login screen
     * 
     * @param event action event
     * @throws IOException exception
     */
    @FXML
    void logOutButton(ActionEvent event) throws IOException {
    	
    	if(model == null) {
    		
    	}else {
    		//model.setObservableList(obsList);
    	}
    	
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
		mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage.setUserData(obsList);
		
		//DataModel model = new DataModel();
		//model.setObservableList(obsList);
		//System.out.println(obsList);
		
		mainStage.setTitle("Admin Screen");
		
		
		LoginController.start(mainStage);
		
		//mainStage.setUserData(obsList);
		scene = new Scene(root);
		mainStage.setScene(scene);
		
		
		

    }
    
    
    /**
     * Save button for when admin is saving data to list
     * 
     * @param event action event
     * @throws IOException exception
     */
    @FXML
    void saveButton(ActionEvent event) throws IOException {
    	
    	
    	
    	
    	
    	if(obsList == null ) {
    		obsList = FXCollections.observableArrayList();
    		
    	}
    	
    	if(userListView == null ) {
    		
    		//userListView = new ListView();
    	}
    	
    	
    	
    	
    	
    	for(User user: obsList) {
    		if(user.name.equalsIgnoreCase(userNameText.getText())) {
    		//if(userNameText.getText().equalsIgnoreCase(user.name)) {
    			duplicateEntry.setVisible(true);
    			break;
    		}
    		else {
    			duplicateEntry.setVisible(false);
    		}
    	}
    	
    	
    	if(userNameText.getText().equalsIgnoreCase("admin")){
			duplicateEntry.setVisible(true);
		}
    	
//    	if (userNameText.getText().isBlank() == true) {
//			duplicateEntry.setVisible(true);
//		}
//    	
//    	if (userNameText.getText().isEmpty() == true) {
//			duplicateEntry.setVisible(true);
//		}
    	
    	if(duplicateEntry.isVisible() == true) {
    		
    		userNameText.setText("");
        	passwordText.setText("");
        	
        	
    		
    	}else {
    		newUser = new User(userNameText.getText()," ",passwordText.getText());
        	
    		
    		
    		
    		Serialization.users.add(newUser);
        	
        	
        	obsList.add(newUser);
        	//userListView.getItems().add("Hello");
        	//this.obsList.addAll(newUser);
        	
        	
        	userListView.setItems(obsList);
        	
        	
        	
        	//obsList.sort(Comparator.comparing(User::getName, String.CASE_INSENSITIVE_ORDER));
    	    
        	
        	
        	if(model == null) {
        		
        		//model.setObservableList(obsList);
        	}else {
        		//model.setObservableList(obsList);
        	}
        	//model.setObservableList(obsList);
        	
        	
        	//System.out.println("Creating user");
        
        	userNameText.setText("");
        	passwordText.setText("");
        	
        	deleteUser.setVisible(true);
        	userNameLabel.setVisible(false);
        	passwordLabel.setVisible(false);
        	userNameText.setVisible(false);
        	passwordText.setVisible(false);
        	saveButton.setVisible(false);
        	clearButton.setVisible(false);
        	userListView.getSelectionModel().select(0);
        	
        	
        	
        	Serialization.serializer();
        	
    	}
    	

    	
    }




    /**
     * intializes data to view  and also loads/saves the data
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		
		
		
		try {
			Serialization.users = Serialization.deserializer();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();
		}
		
//		if(obsList == null) {
			obsList = FXCollections.observableArrayList();
//		}
		
		for(User user: Serialization.users) {
			//System.out.println("IN INITIALIZE: "+ user.name);
    		obsList.add(user);
    		
    		
    	}
		
		userListView.setItems(obsList);
		userListView.getSelectionModel().select(0);
		
	}
    
    
    

	

}
