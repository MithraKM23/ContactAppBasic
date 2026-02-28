/*
 * @author Developer
 * @version 3
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class UserService {
	public void register(String email,String password,String name,String preference) {
		
		//throwing an exception if the email is invalid
		if(!Validation.isValidEmail(email)) {
			throw new IllegalArgumentException("Invalid email");
		}
		
		//throwing an exception if the password is invalid
		if(!Validation.isValidPassword(password)) {
			throw new IllegalArgumentException("Invalid password");
		}
		
		//After Registering printing the success message
		System.out.println("User Registered Successfully");
		
	}
}
