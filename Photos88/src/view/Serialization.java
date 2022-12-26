//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import java.io.*;
import java.util.*;
import app.*;
import view.*;
import view.*;


/**
 * Saves and loads data of the photos application
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class Serialization implements Serializable{
	
	public static ArrayList<User> users = new ArrayList<User>();
	
	public static final String storeDir = "data";
	public static final String storeFile = "users.dat";
	static final long serialVersionUID = 1L;
	
	
	/**
	 * writes data to a file 
	 * @throws IOException
	 */
	public static void serializer() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
		
		oos.writeObject(users);
		oos.close();
	}
	
	/**
	 * Reads data from a file into the appropriate views
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<User> deserializer() throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storeDir + File.separator + storeFile));
		ArrayList<User> tempUsers = new ArrayList<User>();
		tempUsers = (ArrayList) ois.readObject();
//		ArrayList<User> users = new ArrayList<User>(Arrays.asList((User[]) ois.readObject()));
		ois.close();
		return tempUsers;
	}
}
