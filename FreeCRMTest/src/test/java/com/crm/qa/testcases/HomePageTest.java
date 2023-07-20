package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	//Testcases should be independent
public HomePageTest()
{
	super();
}
@BeforeMethod
public void setup() throws InterruptedException
{
	initialiazation();
	loginPage=new LoginPage();
	homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
}
@Test(priority=1)
public void verifyHomePageTitleTest()
{
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Cogmento123 CRM","Home Page Title is not matchd");//if testcase failed only print that message
}
@Test(priority=2)
public void verifyUsernameLabelTest() {
	boolean label=homePage.verifyUserNameLabel();
	Assert.assertTrue(label);
}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
