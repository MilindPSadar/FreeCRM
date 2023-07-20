package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//span[contains(text(),'M S')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskLink;
	public HomePage()//Initialising page objects
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	public String verifyHomePageTitle() 
	{
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink()
	{
		 contactsLink.click();
		return new ContactsPage();
		}
	public DealsPage clickOnDealsLink()
	{
		 dealsLink.click();
		return new DealsPage();
		}
	public TasksPage clickOnTaskLink()
	{
		 taskLink.click();
		return new TasksPage();
		}
	
}
