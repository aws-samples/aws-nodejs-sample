package org.tq.openmrs.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageServiceTypesPage {

	WebDriver driver;
	public ManageServiceTypesPage(WebDriver driver)
	{
		 this.driver = driver;
	}
	public HashMap<String,String> addServiceType(String serviceName)
	{
		
		HashMap<String,String> hMap = new HashMap<String,String>();

		driver.findElement(By.cssSelector(".confirm.appointment-type-label.right")).click();
		driver.findElement(By.id("name-field")).clear();
		hMap.put("serviceName", serviceName);
		driver.findElement(By.id("name-field")).sendKeys(serviceName);
		hMap.put("duration","10");
		driver.findElement(By.id("duration-field")).sendKeys("10");
		hMap.put("description","Adding Service Type");
		driver.findElement(By.id("description-field")).sendKeys("Adding Service Type");
		driver.findElement(By.id("save-button")).click();
		return hMap;
				
	}
	public boolean  isServiceTypeAvailable(String serviceName)
	{

		boolean result = false;
		//Identify the List of Pages and navigate to every page
		List<WebElement> pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
		System.out.println("Size of pagesList" + pageList.size());
		outer:
		for(int i=0;i<pageList.size();i++)
		{
			pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
			pageList.get(i).click(); 
			 
			List<WebElement> trList = driver.findElements(By.cssSelector("#appointmentTypesTable>tbody>tr>td:nth-of-type(1)"));	
			System.out.println("Size of the Table row Lst " + trList.size());
			for(int j=0;j<trList.size();j++)
			{
				System.out.println(trList.get(j).getText());
				if(trList.get(j).getText().contains(serviceName))
				{
					System.out.println("Service Name Found!!!!");
					result = true;
					break outer;
				}
			}
		 
		}
		return result;
	}
	public boolean  isServiceTypeAvailable(HashMap<String,String> hMap)
	{

		boolean result = false;
		//Identify the List of Pages and navigate to every page
		List<WebElement> pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
		System.out.println("Size of pagesList" + pageList.size());
		outer:
		for(int i=0;i<pageList.size();i++)
		{
			pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
			pageList.get(i).click(); 
			 
			List<WebElement> trList = driver.findElements(By.cssSelector("#appointmentTypesTable>tbody>tr>td:nth-of-type(1)"));	
			System.out.println("Size of the Table row Lst " + trList.size());
			for(int j=0;j<trList.size();j++)
			{
				System.out.println(trList.get(j).getText());
				if(trList.get(j).getText().contains(hMap.get("serviceName")))
				{
					System.out.println("Duration Xpath" + ".//*[@id='appointmentTypesTable']/tbody/tr["+(j+1) +"]/td[2]");
					String duration = driver.findElement(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr["+(j+1) +"]/td[2]")).getText();
					String description = driver.findElement(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr["+(j+1) +"]/td[3]")).getText();
					if(hMap.get("duration").equals(duration) && hMap.get("description").equals(description) )
					{
						result = true;
						System.out.println("Duration and Descrition are equal!!!!");
						break outer;
						 
					}
					 
					System.out.println("Service Name Found!!!!");
					 
				}
			}
		 
		}
		return result;
	}
}
