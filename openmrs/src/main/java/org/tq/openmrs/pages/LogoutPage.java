package org.tq.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {


	WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
		public void logout()
		{
			//Logout
			 driver.findElement(By.cssSelector(".logout>a")).click();
			
		}
}
