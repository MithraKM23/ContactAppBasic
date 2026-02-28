/*
 * @author Developer
 * @version 2
 */

package com.seveneleven.contactAppBasic.userRegistration;

public interface Authentication {
	boolean login(User user,String email,String Password);
	
}
