package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.CommonFunctions;

public class HomePage extends CommonFunctions{
	
	@FindBy(xpath = "//div[text()='Satish']/../../..")
	WebElement username;
	
	@FindBy(xpath = "//div[text()='Logout']")
	WebElement logOut;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogOut(){
		hoverOnElement(username);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		safeClick(logOut);
	}

}
