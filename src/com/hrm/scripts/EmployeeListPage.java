     package com.hrm.scripts;	
     
	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import org.testng.Reporter;

	import com.hrm.common.HomePage;

	public class EmployeeListPage extends HomePage{
		
		@FindBy(id="btnDelete")
		private WebElement btnDelete;
		
		@FindBy(id="dialogDeleteBtn")
		private WebElement btnOK;

		public EmployeeListPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public void verifyEmployeePresentInTable(String fn)
		{
			String xP = "//table[@id='resultTable']//a[.='"+fn+"']";
			System.out.println("XPATH:"+xP);
			boolean empPresent = true;
			try
			{
			WebElement element = driver.findElement(By.xpath(xP));//NoSuch Element exception by FindElement
			waitUntillElementIsdisplayed(element); // Element is present in source code but not visible --> Timeout Exception
			Reporter.log("PASS: Employee Present in Table:"+fn,true);
			empPresent = true;
			}
			catch(Exception e)
			{
				Reporter.log("FAIL: Employee Not Present in Table");
				empPresent=false;		
			}
			
			Assert.assertTrue(empPresent);
		}
		
		public void selectEmployeeCheckBox(String fn)
		{
			String xP1 = "//a[.='"+fn+"']/../..//input[@type='checkbox']";
			driver.findElement(By.xpath(xP1)).click();
		}
		
		public void clickDelete()
		{
			waitUntillElementIsdisplayed(btnDelete);
			btnDelete.click();
		}
		
		public void clickOK_OfDeleteRecordPopup()
		{
			waitUntillElementIsdisplayed(btnOK);
			btnOK.click();
		}	
		
		public void verifyEmployeeNotPresentInTable(String fn)
		{
			String xP = "//table[@id='resultTable']//a[.='"+fn+"']";
			System.out.println("XPATH:"+xP);
			boolean empPresent = true;
			try
			{
			WebElement element = driver.findElement(By.xpath(xP));//NoSuch Element exception by FindElement
			waitUntillElementIsdisplayed(element); // Element is present in source code but not visible --> Timeout Exception
			Reporter.log("FAIL:Employee Present in Table:"+fn,true);
			empPresent = true;
			}
			catch(Exception e)
			{
				Reporter.log("PASS: Employee Not Present in Table:"+fn,false);
				empPresent=false;		
			}
			
			Assert.assertFalse(empPresent);
		}	
	}

