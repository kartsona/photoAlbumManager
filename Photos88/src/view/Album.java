package view;

//Cliff Grandin
//NetID: cjg189
//
//Kartik Sonavane
//NetID: ks1324
//

import java.io.*;
import java.util.*;
import view.*;
import app.*;
//simport model.*;


/**
 * Album class for all album storage
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class Album implements Serializable{

	String albumName;
	String albumDate;
	ArrayList<Photo> photos = new ArrayList<Photo>();
	
	/**
	 * Constructor for album with one parameter
	 * 
	 * @param albumName album name 
	 */
	public Album(String albumName) {
		this.albumName = albumName;
		
	}
	
	/**
	 * Constructor for album with two parameter
	 * 
	 * @param albumName album name
	 * @param photos photos arraylist to store all the photos
	 */
	public Album(String albumName, ArrayList<Photo> photos) {
		this.albumName = albumName;
		this.photos = photos;
	}
	
	/**
	 * gets the name of the object being requested
	 * 
	 * @return album name
	 */
	public String getName() {
		return albumName;
	}
	
	/**
	 * changes the name of the album during editting
	 * 
	 * @param newName new name of album
	 */
	public void changeName(String newName) {
		albumName = newName;
	}
	
	/**
	 * gets the photos from the array list
	 * 
	 * @return photo 
	 */
	public ArrayList<Photo> getPhotos() {
		return photos;
	}
	
	/**
	 * adds photo to the object
	 * 
	 * @param newPhoto new photo being added
	 */
	public void addPhoto(Photo newPhoto) {
		photos.add(newPhoto);
	}
	
	
	/**
	 * deletes photo form arraylist 
	 * 
	 * @param delPhoto arraylist
	 */
	public void deletePhoto(Photo delPhoto) {
		photos.removeIf(photo -> photo.getName().equals(delPhoto.getName()));
	}
	
	
	/**
	 * String for printing out name of album
	 */
	public String toString() {
		return albumName;
	}
}
