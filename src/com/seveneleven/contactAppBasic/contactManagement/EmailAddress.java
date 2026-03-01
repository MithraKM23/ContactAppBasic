/*
 * @author Developer
 * @version 6
 */

package com.seveneleven.contactAppBasic.contactManagement;

import java.util.regex.Pattern;

public class EmailAddress {
	private String email;
	public EmailAddress(String email) {
		String emailRegex="^[A-Za-z0-9+_.-]+@(.+)$";
		
		//Checking if the email address matches the emailRegex else throw an exception
		if(!Pattern.matches(emailRegex, email)) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email=email;
	}
	public String getemail() {
		return email;
	}
	@Override
	public String toString() {
		return "Email: "+ email;
	}

}
