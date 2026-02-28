/*
 * @author Developer
 * @version 4
 */

package com.seveneleven.contactAppBasic.contactManagement;

//Inheriting PersonConatct from Contact
public class PersonContact extends Contact{
	private String dateOfBirth;

	//Creating Constructor using super keyword and assigning the dateOfBirth
	public PersonContact(String name,String dateOfBirth) {
		super(name);
		this.dateOfBirth=dateOfBirth;
	}
	
	//Returning DateOfBirth
	public String getDateOfBirth() {
		return dateOfBirth;
	}

}

