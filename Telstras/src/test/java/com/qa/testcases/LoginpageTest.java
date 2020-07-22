package com.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.util.CommonFunctions;

public class LoginpageTest extends CommonFunctions{
	LoginPage loginpage;
	SearchPage searchPage;
	
	public LoginpageTest() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	@BeforeMethod
	public void setup(){
		initilization();
		loginpage = new LoginPage();
		searchPage = new SearchPage();
	}	
	
	@Test
	public void loginTest() throws InterruptedException{
		getTestDataFromExcel();
		//loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginpage.login(userName, password);
		searchPage.searchForProduct();
		searchPage.clickOnRandomProduct();
		searchPage.clickOnAddToCartButton();
		searchPage.verifyDetails();
		searchPage.clickOnplaceorderButton();
		searchPage.clickonDeliverHereButton();
		searchPage.clickoncontinueButton();
		searchPage.clickonFlipkartLogo();
		searchPage.clickOnLogOut();
	}
	
	
	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
	 

}
