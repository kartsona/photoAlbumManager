

//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package app;



import java.io.IOException;

import view.AdminSubSystemController;
import view.LoginController;
//import view.PhotoController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * Start of Photos88 application
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class Photos extends Application {

	public void start(Stage primaryStage) throws Exception {
		

		
		Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
		//Parent root = FXMLLoader.load(getClass().getResource("/view/AlbumPhotos.fxml"));
		//Parent root = FXMLLoader.load(getClass().getResource("/view/UserAlbum.fxml"));
		//Parent root = FXMLLoader.load(getClass().getResource("/view/SlideShow.fxml"));
		
		
		Scene scene = new Scene(root);
		//LoginController.start(primaryStage);
		
		//AdminSubSystemController.start(primaryStage);
		
		primaryStage.setTitle("Login Screen");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene); 
		//primaryStage.setOnHidden(e -> SongLibController.exit());
		primaryStage.setOnHidden(e -> {
			try {
				LoginController.exit();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    Platform.exit();
		    System.exit(0);
		});
		primaryStage.show();
		
		
		
		
		
	}
	
	
	
	
	
	/**
	 * Main for Photos88
	 * 
	 * @param args
	 */
	public static void main(String[] args) { 
		launch(args);
	}
	

}


