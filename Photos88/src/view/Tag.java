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
 * Start of Photos88 application
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */
public class Tag implements Serializable{
	
	String tagType;
	String tagValue;
	
	/**
	 * Constructor with 2 arguments
	 * @param tagType type of tag
	 * @param tagValue value of tag
	 */
	public Tag(String tagType, String tagValue) {
		this.tagType = tagType;
		this.tagValue = tagValue;
	}
	
	
	/**
	 * get tag type 
	 * @return tagType
	 */
	public String getTagType() {
		return tagType;
	}
	
	/**
	 * get the tag value that is being requested
	 * @return tag value
	 */
	public String getTagValue(){
		return tagValue;
	}
	
	/**
	 * String to print all the data out
	 */
	public String toString() {
		return "(" + tagType + "," + tagValue + ")";
	}
}
