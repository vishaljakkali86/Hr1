package com.hrm.scripts;

import org.testng.annotations.Test;
import com.hrm.common.BaseTest;

public class ExplicitLoginScenario extends BaseTest{
	public ExplicitLoginScenario(){
		loginRequired=false;
		logoutRequired=false;
	}
	@Test
	public void testLoginScenario(){
		
		log.info("This is from ExplicitLoginScenario");
	}
}
