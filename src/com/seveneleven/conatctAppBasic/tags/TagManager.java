/*
 * @author Developer
 * @version 11
 */

package com.seveneleven.conatctAppBasic.tags;

import java.util.HashSet;
import java.util.Set;

public class TagManager {
	private Set<Tag> allTags=new HashSet<>();
	
	//Create Tag
	public void createTag(String tagName) {
		Tag tag= new Tag(tagName);
		if(allTags.add(tag)) {
			System.out.println("Tag created Successfully");
		}
		else {
			System.out.println("Tag already exists.");
		}
	}
	
	//View tags
	public void viewAllTags() {
		if(allTags.isEmpty()) {
			System.out.println("No tags created yet.");
			return;
		}
		System.out.println("Available tags: ");
		for(Tag tag : allTags) {
			System.out.println("- "+tag);
		}
	}
	
	//Get Tag by Name
	public Tag getTagByName(String name) {
		for(Tag tag: allTags) {
			if(tag.getName().equalsIgnoreCase(name)) {
				return tag;
			}
		}
		return null;
	}
	
	
	public Set<Tag> getAllTags(){
		return allTags;
	}
}
