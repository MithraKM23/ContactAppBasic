/*
 * @author Developer
 * @version 5
 */

package com.seveneleven.contactAppBasic.contactManagement;

//Inheriting OrganizationContact from Contact
public class OrganisationContact extends Contact{
	private String companyName;

	//Creating Constructor using the super keyword and assigning company name
	public OrganisationContact(String name,String companyName) {
		super(name);
		this.companyName=companyName;
		
	}
	
	//Returning company name
	public String getCompanyName() {
		return companyName;
	}
	
	//Overriding the toString() method to return the company name along with the fields in the Contact class
	@Override
	public String toString() {
		return super.toString()+"\nCompany Name: "+companyName;
	}
	

}