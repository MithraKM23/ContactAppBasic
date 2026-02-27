/*
 * @author Developer
 * @version 1
 */

package com.seveneleven.contactAppBasic.userRegistration;

import java.util.regex.Pattern;

public class Validation {
	private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
	
	//Returns True if the email matches the emailRegex
	public static boolean isValidEmail(String email) {
		return Pattern.matches(emailRegex, email);
	}
	
	//Returns True if the password matches the passwordRegex
	public static boolean isValidPassword(String Password) {
		return Pattern.matches(passwordRegex, Password);
	}
}
