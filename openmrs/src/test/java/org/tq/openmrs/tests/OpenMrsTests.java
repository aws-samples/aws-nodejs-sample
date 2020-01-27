package org.tq.openmrs.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tq.openmrs.pages.HomePage;
import org.tq.openmrs.pages.LoginPage;
import org.tq.openmrs.pages.LogoutPage;
import org.tq.openmrs.pages.ManageServiceTypesPage;
 
import org.tq.util.BaseClass;

public class OpenMrsTests extends BaseClass{
	 
	
 
	@Parameters({"username","password","serviceName"})
	@Test(enabled=false) 
	public void verifyServiceTypeAvailable(String username,String password,String serviceName)
	{
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = new HomePage(driver);
		ManageServiceTypesPage servicePage = new ManageServiceTypesPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);
		lPage.login(username,password);
		System.out.println("login successful");
		hPage.navigateToServiceTypes();
		boolean result = servicePage.isServiceTypeAvailable(serviceName);
		Assert.assertTrue(result);
		logoutPage.logout();
	}
	@Parameters({"username","password" })
	@Test
	public void verifyAddServiceTypeAvailable(String username,String password )
	{
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = new HomePage(driver);
		ManageServiceTypesPage servicePage = new ManageServiceTypesPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);
		lPage.login(username,password);
		hPage.navigateToServiceTypes();
		Random rnd = new Random();
		String serviceName = "Test" + rnd.nextInt(2000000);
		HashMap<String,String> hMap = servicePage.addServiceType(serviceName);
		boolean result = servicePage.isServiceTypeAvailable(hMap);
		Assert.assertTrue(result);
		logoutPage.logout();
	}

 
	@Test(dataProvider="DP") 
	public void verifyListServiceTypeAvailable(String username,String password,String serviceName)
	{
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = new HomePage(driver);
		ManageServiceTypesPage servicePage = new ManageServiceTypesPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);
		lPage.login(username,password);
		hPage.navigateToServiceTypes();
		boolean result = servicePage.isServiceTypeAvailable(serviceName);
		Assert.assertTrue(result);
		logoutPage.logout();
	}
	
	@DataProvider(name="DP")
	public String[][] feedData() throws jxl.read.biff.BiffException, IOException
	{
		return readXLSFile("InputData.xls", "sanity");
	}
}
