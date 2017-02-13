package com.hrm.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.common.HomePage;

public class Add_EmployeePage extends HomePage
{

	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	
	@FindBy(id = "btnSave")
	private WebElement Save;
	
	
	public Add_EmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void send_FirstName()
	{
		waitUntillElementIsdisplayed(firstName);
		firstName.sendKeys("vishal");
	}
	public void send_lastName()
	{
		waitUntillElementIsdisplayed(lastName);
		lastName.sendKeys("jakkali");
	}
	
	public void click_save()
	{
		waitUntillElementIsdisplayed(Save);
		Save.click();
	}
	
}
