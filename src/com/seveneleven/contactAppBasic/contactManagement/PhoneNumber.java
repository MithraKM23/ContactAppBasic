/*
 * @author Developer
 * @version 5
 */

package com.seveneleven.contactAppBasic.contactManagement;
public class PhoneNumber {
	private String number;
	public PhoneNumber(String number) {
		
		//Checking if the phone Number has 10 digits else throw an exception
		if(!number.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must be 10 digits");
		}
		this.number=number;
	}
	@Override
	public String toString() {
		return "Phone: "+number;
	}
}
