/*
 * @author Developer
 * @version 3
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class PremiumUser extends User{
	
	//Creating a constructor using the super keyword
	public PremiumUser(String name, String email, String password,String preference) {
		super(name, email, password,preference);
	}
	
	//Overriding a method which is already in the parent class to get the User Type
	@Override
	public String getUserType() {
		return "PREMIUM";
	}
}