/*
 * @author developer
 * @version 2
 */

package com.seveneleven.contactAppBasic.userRegistration;

public class Session {
	private User loggedInUser;
	
	//When the user successfully loggedIn the session starts
	public void startSession(User user) {
		this.loggedInUser=user;
		System.out.println("Session started for: "+user.getName());
	}
	
	//Printing the session ended message
	public void endSession() {
		System.out.println("Session ended for: "+loggedInUser.getName());
		this.loggedInUser=null;
	}
	public User getLoggedInUser() {
		return loggedInUser;
	}
}
