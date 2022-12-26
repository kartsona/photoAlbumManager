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
 * Photos class for manipulating photos data
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class Photo implements Serializable{
	
	String albumName;
	String albumDate;
	String photoName;
	Date photoDate;
	String caption;
	String fileLocation;
	ArrayList<Tag> tags;
	
	/**
	 * Constructor for Photo
	 * @param name name of photo
	 * @param date date of photo
	 */
	public Photo(String name, Date date) {
		this.photoName = name;
		this.photoDate = date;	
	}
	
	/**
	 * Constructor for Photo
	 * 
	 * @param name name of photo
	 * @param date date created
	 * @param fileLocation where the photo is located
	 */
	public Photo(String name, Date date, String fileLocation) {
		this.photoName = name;
		this.photoDate = date;
		this.fileLocation = fileLocation;
	}
	
	/**
	 * gets name of photo
	 * @return photoName 
	 */
	public String getName() {
		return photoName;
	}
	
	
	/**
	 * changes the name of the photo
	 * 
	 * @param newName changed name
	 */
	public void changeName(String newName) {
		photoName = newName;
	}
	
	
	/**
	 * get the date of the photo
	 * @return photo date
	 */
	public Date getDate() {
		return photoDate;
	}
	
	/**
	 * get the caption of the photo
	 * @return caption of the photo
	 */
	public String getCaption() {
		return caption;
	}
	
	
	/**
	 * gets the location of where the file is stored
	 * @return file location, the location of the file
	 */
	public String getFileLocation() {
		return fileLocation;
	}
	
	/**
	 * get the tags in the arraylist
	 * @return tags 
	 */
	public ArrayList<Tag> getTags(){
		return tags;
	}
	
	/**
	 * add a tag to a photo arraylist
	 * @param newTag
	 */
	public void addTag(Tag newTag) {
		tags.add(newTag);
	}
	
	/**
	 * delete the tag of photo
	 * @param delTag
	 */
	public void deleteTag(Tag delTag) {
		tags.removeIf(tag -> tag.getTagType().equals(delTag.getTagType()) && tag.getTagValue().equals(delTag.getTagValue()));
	}
	
	/**
	 * prints out the name of the photo
	 */
	public String toString() {
		return photoName;
	}
	

}
