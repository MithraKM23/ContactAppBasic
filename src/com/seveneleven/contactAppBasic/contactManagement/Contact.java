/*
 * @author Developer
 * @version 12
 */

package com.seveneleven.contactAppBasic.contactManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.seveneleven.conatctAppBasic.tags.*;

//import com.myContactBasic.contactManagement.EmailAddress;
//import com.myContactBasic.contactManagement.PhoneNumber;

public class Contact {
	//creating a contact with id,name,phoneNo,Email and id fields
		private int id;
		private String name;
		private List<PhoneNumber> phoneNo;
		private List<EmailAddress> email;
		private LocalDateTime createdAt;
		private static int counter = 1;
		private Set<Tag> tags=new HashSet<>();
		public Contact(String name) {
			//assigning unique id using randomUUID function
			this.id = counter++;
			this.name = name;
			this.phoneNo = new ArrayList<>();
			this.email = new ArrayList<>();
			this.createdAt = LocalDateTime.now();
		}
		
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public List<PhoneNumber> getPhoneNo() {
			return phoneNo;
		}
		public List<EmailAddress> getEmail() {
			return email;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		
		//Adding phone Number in the list
		public void addPhoneNumber(PhoneNumber phoneno) {
			phoneNo.add(phoneno);
		}
		
		//Adding Email address in the list
		public void addEmailAddress(EmailAddress emailadd) {
			email.add(emailadd);
		}
		
		public void addTag(Tag tag) {
			tags.add(tag);
		}
		public void removeTag(Tag tag) {
			tags.remove(tag);
		}
		public Set<Tag> getTags(){
			return tags;
		}
		
		//From list adding it to the string Builder and returning as a String
		@Override
		public String toString() {
			StringBuilder phoneDetails=new StringBuilder();
			for(PhoneNumber p:phoneNo) {
				phoneDetails.append(p.toString()).append("\n");
			}
			
			StringBuilder emailDetails = new StringBuilder();
			for(EmailAddress e:email) {
				emailDetails.append(e.toString()).append("\n");
			}
			return "Contact ID: "+id+"\n"+"Name: "+name+"\n"+"Phone Numbers: "+phoneDetails+"Email Address: "+emailDetails+"Created At: "+createdAt+"\n"+"Tags: "+tags;
		}
		public Contact(Contact other) {
			this.id=other.id;
			this.name=other.name;
			this.createdAt=other.createdAt;
			this.phoneNo = new ArrayList<>();
			for(PhoneNumber p :other.phoneNo) {
				this.phoneNo.add(new PhoneNumber(p.getNumber()));
			}
			this.email=new ArrayList<>();
			for(EmailAddress e :other.email) {
				this.email.add(new EmailAddress(e.getemail()));
			}
		}
		public void setName(String name) {
			if (name==null || name.trim().isEmpty()) {
				throw new IllegalArgumentException("Name cannot be empty");
			}
			this.name=name;
		}
		public void clearPhoneNumbers() {
			phoneNo.clear();
		}
		public void clearEmail() {
			email.clear();
		}
}
