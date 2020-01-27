package org.tq.openmrs.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tq.util.BaseClass;

 
public class ParametersEx extends BaseClass{
 
	 
	 
	@Parameters({"username","password"})
	@Test
	public void login(String username,String password)
	{
		System.out.println(driver.getTitle());
		System.out.println("username value " + username);
		System.out.println("password value " + password);

	}
}
