/*
 * @author developer
 * @version 1
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class FreeUser extends User{
	
	//Assigning values using the super keyword in the constructor
	public FreeUser(String name, String email, String password,String preference) {
		super(name, email, password,preference);
		// TODO Auto-generated constructor stub
	} 
	
	//Overriding the method from the parent class user
	@Override
	public String getUserType() {
		return "FREE";
	}
}
