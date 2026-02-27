/*
 * @author Developer
 * @version 1
 */

package com.seveneleven.contactAppBasic.userRegistration;

import java.security.MessageDigest;

public class PasswordHashing {
	public static String hashPassword(String password) {
		try {
			//Hashing the password using SHA Algorithm for security
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			
			//Storing the password as a bytes in the byte array
			byte[] bytes=md.digest(password.getBytes());
			
			//Create a StringBuilder and Store the bytes
			StringBuilder sb=new StringBuilder();
			for(byte b : bytes) {
				sb.append(String.format("%02x", b));
			}
			
			//Return it as a String
			return sb.toString();
		}
		catch(Exception e) {
			throw new RuntimeException("Error hashing password");
		}
	}
}
