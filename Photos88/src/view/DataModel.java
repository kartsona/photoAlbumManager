//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Data Model not used at the moment
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class DataModel {
	
	public ObservableList<Photo> obsList = FXCollections.observableArrayList();
	
	/**
	 * sets observable list 
	 * @param obsList
	 */
	public void setObservableList(ObservableList<Photo> obsList) {
		this.obsList = obsList;
		//System.out.println("This.obsList: "+this.obsList);
		
	}
	
	/**
	 * gets observable list 
	 * @param obsList
	 */
	public ObservableList<Photo> getObservableList() {
		//System.out.println("In gettobsList "+obsList);
		return obsList;
	}

}


