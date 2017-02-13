package com.hrm.common;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hrm.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import generics.Property;
import generics.Utility;

@Listeners(CustomListeners.class)
public class BaseTest implements AutomationConstants{
	public Logger log;
	public WebDriver driver;
	public ExtentTest testReport;
	
	public static String url;
	public static String un;
	public static String pw;
	public static String homePageURL;
	public static String loginPageURL;
	public static long timeout;
	public static ExtentReports eReport;
	public static boolean loginRequired=true;
	public static boolean logoutRequired=true;
	
	public BaseTest() {
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}
	
	@BeforeSuite
	public void initFrameWork()
	{
		log.info("initializing ExtentReport");
		eReport=new ExtentReports(REPORT_PATH+Utility.getFormatedDateTime()+".html");
		url=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "URL");
		un=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "UN");
		pw=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "PW");
		homePageURL=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "HOME");
		loginPageURL=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LOGIN");
		timeout=Long.parseLong(Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "IMPLICIT"));
	}
	
	@AfterSuite
	public void closeFrameWork()
	{
		log.info("finalizing ExtentReport");
		eReport.flush();
	}
	
	@Parameters({"browser"})
	@BeforeTest
	public void initBrowser(@Optional("firefox") String  browser){
		log.info("Execution started on Browser:"+browser);
			}
	
	@Parameters({"browser"})
	@AfterTest
	public void closeBrowser(@Optional("firefox") String  browser){
		log.info("Execution completed on Browser:"+browser);
	}
	@Parameters({"browser"})
	@BeforeClass
	public void initApplication(@Optional("firefox") String  browser){
		
		log.info("Browser:"+browser);
		if(browser.equals("chrome")){
			System.setProperty(CHROME_Key, DRIVER_PATH+CHROME_FILE);
			driver=new ChromeDriver();
		}
		else{
			System.setProperty(Gecko_Key, DRIVER_PATH+GECKO_FILE);
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		log.info("TimeOut:"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		
		
	}

	@AfterClass
	public void cleanApplication(){
		driver.quit();
	}
	
	@BeforeMethod
	public void preCondition(Method method){
		testReport=eReport.startTest(method.getName());
		if(loginRequired){
			log.info("implicit login");
			driver.navigate().to(url);
			LoginPage loginPage=new LoginPage(driver);
			loginPage.setUserName(un);
			loginPage.setPassword(pw);
			loginPage.clickLogin();
			loginPage.verifyURLhas(homePageURL);
		}else{
			log.warn("explicit login required");
		}
		loginRequired=true;
	}
	
	@AfterMethod
	public void postCondition(ITestResult result){
		if(logoutRequired){
			log.info("implicit logout");
			HomePage homePage=new HomePage(driver);
			homePage.clickWelCome();
			homePage.clickLogout();
			homePage.verifyURLhas(loginPageURL);
		}
		else{
			log.warn("explicit logout required");
		}
		logoutRequired=true;
		if(result.getStatus()==ITestResult.FAILURE)
		{
			testReport.log(LogStatus.FAIL,"Script failed check log for details");
		}
		else
		{
			testReport.log(LogStatus.PASS, "stepName", "details");
		}
		eReport.endTest(testReport);
	}
}





