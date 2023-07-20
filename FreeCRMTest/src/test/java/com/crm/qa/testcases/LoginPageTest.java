package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
  public LoginPageTest()
  {
	  super();
  }
	
	@BeforeMethod
	public void setup()
	{
		initialiazation();
		loginPage=new LoginPage();
	}
	//Test Cases should be separated- independent each other
	//before each test case- launch the browser and login
	//after each test case- close the browser
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validiateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	@Test(priority=2)
	public void logoVerificationTest()
	{
		boolean flag=loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
