/*
 * @author developer
 * @version 6
 */

package com.seveneleven.contactAppBasic.userRegistration;
import com.seveneleven.contactAppBasic.contactManagement.*;

import java.util.ArrayList;
import java.util.List;
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
		System.out.println("Enter your Preference(Light/Dark): ");
		String preference=sc.nextLine();

		//Storing the hashed password for authentication
		String hashedPassword = PasswordHashing.hashPassword(password);
		User registeredUser = new User(name,email,hashedPassword,preference);
		System.out.println("Registartion Successful");

		System.out.println("\nUser Login");
		System.out.print("Enter Email: ");
		String loginEmail=sc.nextLine();
		System.out.println("Enter Password: ");
		String loginPassword=sc.nextLine();
		Authentication auth = new BasicAuth();

		//Authenticate user login
		try {
			boolean isLoggedIn=auth.login(registeredUser, loginEmail, loginPassword);
			if(isLoggedIn) {
				System.out.println("Login Successful");
				Session session=new Session();
				session.startSession(registeredUser);
				System.out.println("Welcome "+session.getLoggedInUser().getName());
				session.endSession();

				//On successful login, ask user for profile management using switch case
				System.out.println("\nProfile Management");
				System.out.println("1. Update Name");
				System.out.println("2. Update Email");
				System.out.println("3. Change Password");
				System.out.println("4. Change preference");
				System.out.println("5. quit");
				System.out.println("Enter your choice");
				int choice=sc.nextInt();
				sc.nextLine();
				try {
					switch(choice) {
					case 1:
						System.out.println("Enter New name: ");
						String newName=sc.nextLine();
						registeredUser.setName(newName);
						System.out.println("Name Updated Successfully");
						break;
					case 2:
						System.out.println("Enter New Email: ");
						String newEmail=sc.nextLine();
						registeredUser.setEmail(newEmail);
						System.out.println("Email Updated Successfully");
						break;
					case 3:
						System.out.println("Enter old password: ");
						String oldpassword=sc.nextLine();
						System.out.println("Enter new password: ");
						String newpassword=sc.nextLine();
						registeredUser.changePassword(oldpassword, newpassword);
						System.out.println("Password changed successfully");
						break;
					case 4:
						System.out.println("Change your prefernce (Light/Dark): ");
						String pref=sc.nextLine();
						registeredUser.setPreference(pref);
						System.out.println("Preference Updated.");
						break;
					case 5:
						break;
					default:
						System.out.println("Invalid option");
					}

				}
				catch(IllegalArgumentException e) {
					System.out.println("Error: "+e.getMessage());
				}
			}
			else {
				System.out.println("Invalid Email or Password");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
		}
		//Creating a choice of Contact for person or organization
		System.out.println("\nCREATE CONTACT");
		System.out.println("1. Person Contact");
		System.out.println("2. Organisation Contact");
		System.out.println("Choose type: ");
		int type=sc.nextInt();
		sc.nextLine();
		Contact contact=null;
		try {
			if(type==1) {
				System.out.println("Enter Name: ");
				String name1=sc.nextLine();
				System.out.println("Enter Date Of Birth: ");
				String dateOfBirth=sc.nextLine();
				contact=new PersonContact(name1,dateOfBirth);
			}
			else if(type==2) {
				System.out.println("Enter Contact Name: ");
				String name2=sc.nextLine();
				System.out.println("Enter Company Name: ");
				String company=sc.nextLine();
				contact = new OrganisationContact(name2,company);
			}

			//Getting the phone number and email address as input
			System.out.println("Enter phone Number (10 digits): ");
			String phone=sc.nextLine();
			contact.addPhoneNumber(new PhoneNumber(phone));
			System.out.println("Enter Email: ");
			String email1=sc.nextLine();
			contact.addEmailAddress(new EmailAddress(email1));
			System.out.println("\nContact created Successfully");
			System.out.println("Contact ID: "+contact.getId());
			System.out.println("Created At: "+contact.getCreatedAt());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
		}
		List<Contact> contactlist = new ArrayList<>();

		//Adding the contact details in the list
		contactlist.add(contact);
		System.out.println("Enter contact ID to View: ");
		int searchid=Integer.parseInt(sc.nextLine());
		Contact findContact = null;

		//If the entered search id matches the contact id in the list then it will return the person's contact details in that contact id
		for(Contact c : contactlist) {
			if(c.getId() == searchid) {
				findContact=c;
				break;
			}
		}
		if(findContact != null) {
			System.out.println(findContact);
		}
		else {
			System.out.println("Contact not found");
		}

		//Getting the contact id as input from the user to edit the contact details
		System.out.println("Enter contact id to edit: ");
		int editid=Integer.parseInt(sc.nextLine());
		Contact foundContact = null;
		for(Contact c : contactlist) {
			if(c.getId() == editid) {
				foundContact = c;
				break;
			}
		}
		if(foundContact == null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.println("\nEDIT CONTACT");
		System.out.println("1. Edit Name");
		System.out.println("2. Edit phone Number");
		System.out.println("3. Edit Email");
		System.out.println("Choose type");
		int type1=sc.nextInt();
		sc.nextLine();
		Contact backup=new Contact(foundContact);
		try {
			switch(type1) {
			case 1:
				System.out.println("Enter New Name: ");
				String newName=sc.nextLine();
				foundContact.setName(newName);
				System.out.println("Contact updated successfully");
				break;
			case 2:
				foundContact.clearPhoneNumbers();
				System.out.println("Enter new phone Number: ");
				String newphone=sc.nextLine();
				foundContact.addPhoneNumber(new PhoneNumber(newphone));
				System.out.println("Contact updated successfully");
				break;
			case 3:
				foundContact.clearEmail();
				System.out.println("Enter new email: ");
				String newemail=sc.nextLine();
				foundContact.addEmailAddress(new EmailAddress(newemail));
				System.out.println("Contact updated successfully");
				break;
			default:
				break;
			}


		}
		catch(IllegalArgumentException e) {
			foundContact = backup;
			System.out.println("Error: "+e.getMessage());
			System.out.println("Changes reverted");
		}

	}

}

