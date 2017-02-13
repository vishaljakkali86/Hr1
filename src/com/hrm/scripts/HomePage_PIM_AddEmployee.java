package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.common.BaseTest;
import com.hrm.common.HomePage;
import com.hrm.pages.DashboardPage;

public class HomePage_PIM_AddEmployee extends BaseTest
{
	@Test
	public void testHomeAddDeleteEmployee()
	
	{
		//click PIM 
		HomePage dP = new HomePage(driver);
		dP.CliickPIM();
		
		
		//click Add employee
		dP.clickAdd_employee();
		
		//enter first name
		Add_EmployeePage aDemp = new Add_EmployeePage(driver);
		
		aDemp.send_FirstName();
		
		// enter last name
		aDemp.send_lastName();
		
		// click save 
		aDemp.click_save();
		
	}

	
}
