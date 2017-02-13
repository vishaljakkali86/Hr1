package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.common.BaseTest;
import com.hrm.pages.LoginPage;

public class VerifyLogo extends BaseTest{
	public VerifyLogo(){
		loginRequired=false;
		logoutRequired=false;
	}
	@Test
	public void testLogo(){
		LoginPage l=new LoginPage(driver);
		l.verifyLogo();
	}
}
