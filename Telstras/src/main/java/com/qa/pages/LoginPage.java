package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.CommonFunctions;

public class LoginPage extends CommonFunctions {
	
	@FindBy(xpath="//span[text()='Enter Email/Mobile number']/../..//input")
	WebElement username;
	
	@FindBy(xpath="//span[text()='Enter Password']/../..//input")
	WebElement password;
	
	@FindBy(xpath="//button//span[text()='Login']")
	WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginpageTitle(){
		return driver.getTitle();
	}
	
	public void login(String un, String pwd){
		waitForPageLoaded();
		/*username.sendKeys(un);
		password.sendKeys(pwd);*/
		safeSendKeys(username,un);
		safeSendKeys(password,pwd);
		safeClick(loginBtn);
		//loginBtn.click();
		waitForPageLoaded();
	}

}
