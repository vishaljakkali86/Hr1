package com.hrm.scripts;

import org.testng.annotations.Test;
import com.hrm.common.BaseTest;
import com.hrm.common.HomePage;
import com.hrm.pages.LoginPage;

import generics.Excel;

public class VerifyLoginLogout extends BaseTest{
	public VerifyLoginLogout(){
		loginRequired=false;
		logoutRequired=false;
	}
	@Test
	public void testLoginLogout() throws InterruptedException{
		String un=Excel.getCellValue(INPUT_PATH, "VerifyLoginLogout",1,0);
		String pw=Excel.getCellValue(INPUT_PATH, "VerifyLoginLogout",1,1);
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.setUserName(un);
		loginPage.setPassword(pw);
		loginPage.clickLogin();
		
		loginPage.verifyURLhas(homePageURL);
		
		HomePage homePage=new HomePage(driver);
		Thread.sleep(3000);
		homePage.clickWelCome();
		Thread.sleep(3000);
		homePage.clickLogout();
		Thread.sleep(3000);
		homePage.verifyURLhas(loginPageURL);
	}
}
