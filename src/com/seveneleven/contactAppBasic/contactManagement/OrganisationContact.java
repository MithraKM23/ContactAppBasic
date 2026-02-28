/*
 * @author Developer
 * @version 4
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
	

}