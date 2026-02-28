/*
 * @author Developer
 * @version 4
 */

package com.seveneleven.contactAppBasic.contactManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//import com.myContactBasic.contactManagement.EmailAddress;
//import com.myContactBasic.contactManagement.PhoneNumber;

public class Contact {
	//creating a contact with id,name,phoneNo,Email and id fields
		private String id;
		private String name;
		private List<PhoneNumber> phoneNo;
		private List<EmailAddress> email;
		private LocalDateTime createdAt;
		public Contact(String name) {
			//assigning unique id using randomUUID function
			this.id = UUID.randomUUID().toString();
			this.name = name;
			this.phoneNo = new ArrayList<>();
			this.email = new ArrayList<>();
			this.createdAt = LocalDateTime.now();
		}
		public String getId() {
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
		
}
