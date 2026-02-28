/*
 * @author developer
 * @version 2
 */

package com.seveneleven.contactAppBasic.userRegistration;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Getting inputs from the user for registration
		Scanner sc=new Scanner(System.in);
		System.out.println("User Registration:");
		System.out.print("Enter Name: ");
		String name=sc.nextLine();
		System.out.print("Enter Email: ");
		String email=sc.nextLine();
		System.out.print("Enter Password: ");
		String password=sc.nextLine();
		
		//Storing the hashed password for authentication
		String hashedPassword = PasswordHashing.hashPassword(password);
		User registeredUser = new User(name,email,hashedPassword);
		System.out.println("Registartion Successful");
		System.out.println("Name: "+registeredUser.getName());
		System.out.println("Email: "+registeredUser.getEmail());
		System.out.println("\nUser Login");
		System.out.print("Enter Email: ");
		String loginEmail=sc.nextLine();
		System.out.println("Enter Password: ");
		String loginPassword=sc.nextLine();
		Authentication auth = new BasicAuth();
		
		//If login successful printing the welcome message
		try {
			boolean isLoggedIn=auth.login(registeredUser, loginEmail, loginPassword);
			if(isLoggedIn) {
				System.out.println("Login Successful");
				Session session=new Session();
				session.startSession(registeredUser);
				System.out.println("Welcome "+session.getLoggedInUser().getName());
				session.endSession();
			}
			else {
				System.out.println("Invalid Email or Password");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}

