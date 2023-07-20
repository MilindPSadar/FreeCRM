package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory or Object repository
	@FindBy(xpath="//a[text()='Login']")
	WebElement logintab;
	
	@FindBy(xpath="(//img[@class='img-responsive'])[1]")
	WebElement image;
	@FindBy(xpath="//*[@name='email']")
	WebElement email;
	@FindBy(xpath="//*[@name='password']")
	WebElement password;
	@FindBy(xpath="//div[text()='Login']")
	WebElement Loginbtn;
	
	public LoginPage()//Initialising page objects
	{
		PageFactory.initElements(driver, this);
	}
	public String validiateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return image.isDisplayed();
	}
	public HomePage login(String us, String pwd ) throws InterruptedException
	{
		logintab.click();
		email.sendKeys(us);
		Thread.sleep(5000);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		Loginbtn.click();
		return new HomePage();
	}
	

}
