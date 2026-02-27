/*
 * @author Developer
 * @version 1
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class UserService {
	public void register(String email,String password,String name) {
		
		//throwing an exception if the email is invalid
		if(!Validation.isValidEmail(email)) {
			throw new IllegalArgumentException("Invalid email");
		}
		
		//throwing an exception if the password is invalid
		if(!Validation.isValidPassword(password)) {
			throw new IllegalArgumentException("Invalid password");
		}
		
		//After Registering printing the success message and name and email of the user
		System.out.println("User Registered Successfully");
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
	}
}
