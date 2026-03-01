/*
 * @author Developer
 * @version 5
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
	
	//Overriding the toString() method to return the date of birth along with the fields in the Contact class
	@Override
	public String toString() {
		return super.toString()+"\nDate od Birth: "+dateOfBirth;
	}

}

