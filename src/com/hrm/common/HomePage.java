package com.hrm.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//b[.='Admin']")
	private WebElement  Admin_Menu;
	
	@FindBy(xpath="//b[.='PIM']")
	private WebElement  PIM_Menu;
	
	@FindBy(xpath="//b[.='Dashboard']")
	private WebElement  Dashboard_Menu;
	
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement Pim_menu ;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement add_Employee;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	private WebElement employee_list;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	public void clickWelCome()
	{
		welcome.click();
	}
	
	public void clickLogout(){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}
	
	
	
	
	
	public void CliickPIM()
	{
		waitUntillElementIsdisplayed(Pim_menu);
		Pim_menu.click();
	}
	public void clickAdd_employee()
	{
		waitUntillElementIsdisplayed(add_Employee);
		add_Employee.click();
	}
	public void click_EmployeeList()
	{waitUntillElementIsdisplayed(employee_list);
		employee_list.click();
	}
}
