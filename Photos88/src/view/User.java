

//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

package view;

import java.io.*;
import java.util.*;
import view.*;
import app.*;
//import model.*;

/**
 * User class the creates user objects
 * and sets passcodes and album
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class User implements Serializable{
	String name;
	String privilege;
	String password;
	ArrayList<Album> albums = new ArrayList<Album>();
	
	/**
	 * user constuctor with 3 parameters
	 * 
	 * @param name name of user 
	 * @param privilege privilege such as admin or not
	 * @param password password of user
	 */
	public User(String name, String privilege, String password) {
		this.name = name;
		this.privilege = privilege;
		this.password = password;
	}
	
	/**
	 * gets name of user
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets name of password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * gets privilege
	 * @return privilege
	 */
	public String getPrivilege() {
		return privilege;
	}
	
	/**
	 * gets albums
	 * @return albums
	 */
	public ArrayList<Album> getAlbums(){
		return albums;
	}
	
	/**
	 * adds albums to array list
	 * @param newAlbum
	 */
	public void addAlbum(Album newAlbum) {
		albums.add(newAlbum);
	}
	
	/**
	 * removes the album from the arraylist
	 * @param delAlbum
	 */
	public void deleteAlbum(Album delAlbum) {
		albums.removeIf(album -> album.getName().equals(delAlbum.getName()));
	}
	
	/**
	 *toString to print to listview 
	 */
	public String toString() {
		return name;
	}
}
