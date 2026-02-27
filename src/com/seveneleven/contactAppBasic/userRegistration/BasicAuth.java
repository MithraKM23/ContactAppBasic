/*
 * @author Developer
 * @version 2
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class BasicAuth implements Authentication {
	
	//Implementing the method which is declared in the Authentication interface
	public boolean login(User user,String email,String password) {
		if(user==null) {
			throw new IllegalArgumentException("No registered user found");
		}
		
		//Authenticating the email and password of the user
		String hashedInputPassword = PasswordHashing.hashPassword(password);
		if(user.getEmail().equals(email) && user.getPassword().equals(hashedInputPassword)) {
			return true;
		}
		return false;
	}
}
