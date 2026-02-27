/*
 * @author developer
 * @version 1
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class Main {

	public static void main(String[] args) {
		
		//Creating an object for userService and calling the register method for registration
		UserService userservice =  new UserService();
		userservice.register("mithra123@gmail.com","Password@123", "Mithra");

	}

}
