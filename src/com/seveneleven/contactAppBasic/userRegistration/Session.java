package com.seveneleven.contactAppBasic.userRegistration;

public class Session {
	private User loggedInUser;
	public void startSession(User user) {
		this.loggedInUser=user;
		System.out.println("Session started for: "+user.getName());
	}
	public void endSession() {
		System.out.println("Session ended for: "+loggedInUser.getName());
		this.loggedInUser=null;
	}
	public User getLoggedInUser() {
		return loggedInUser;
	}
}
