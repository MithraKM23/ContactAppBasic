/*
 * @author Developer
 * @version 1
 */

package com.seveneleven.contactAppBasic.userRegistration;
public class User {
	
	//creating user fields
	private String name;
	private String email;
	private String password;
	
	//Assigning values through constructor
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	//Checking if the name is valid. if invalid it will throw an exception
	public void setName(String name) {
		if(name==null || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name=name;
	}
	
	//Returning User type
	public String getUserType() {
		return "NORMAL";
	}
	
}