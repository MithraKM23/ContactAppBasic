/*
 * @author Developer
 * @version 3
 */

package com.seveneleven.contactAppBasic.userRegistration;

import java.util.regex.Pattern;

public class User {
	
	//creating user fields
	private String name;
	private String email;
	private String password;
	private String preference;
	
	//Assigning values through constructor
	public User(String name, String email, String password,String preference) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.preference = preference;
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
	public String getPreference() {
		return preference;
	}
	
	//If the name is blank throw an exception
	public void setName(String name) {
		if(name==null || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name=name;
	}
	
	//check if the email matches the emailRegex else throw an exception
	public void setEmail(String email) {
		String emailRegex="[A-za-z0-9+_.-]+@(.+)$";
		if(!Pattern.matches(emailRegex, email)) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email=email;
	}
	
	//Check if the preference is valid else throw an exception
	public void setPreference(String preference) {
		if(!preference.equalsIgnoreCase("Light") && !preference.equalsIgnoreCase("Dark")) {
			throw new IllegalArgumentException("Preference must be light or dark");
		}
		this.preference=preference;
	}
	
	//Method to change the password from old password to new password
	public void changePassword(String oldPassword,String newPassword) {
		String oldHashed=PasswordHashing.hashPassword(oldPassword);
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
		if(!this.password.equals(oldHashed)) {
			throw new IllegalArgumentException("Old Password is incorrect");
		}
		if(!Pattern.matches(passwordRegex, newPassword)) {
			throw new IllegalArgumentException("Password is in invalid format");
		}
		this.password=PasswordHashing.hashPassword(newPassword);
		System.out.println("Password changed successfully");
	}
	
	//Returning User type
	public String getUserType() {
		return "NORMAL";
	}
	
}