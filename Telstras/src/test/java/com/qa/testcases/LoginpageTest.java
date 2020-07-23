package com.qa.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import com.qa.pages.AddToCartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.util.CommonFunctions;

public class LoginpageTest extends CommonFunctions{
	LoginPage loginpage;
	SearchPage searchPage;
	AddToCartPage addToCartPage;
	HomePage homePage;
	
	public LoginpageTest() {
		super();
	}	
	
	@BeforeTest
	public void setup(){
		initilization();
		loginpage = new LoginPage();
		searchPage = new SearchPage();
		addToCartPage = new AddToCartPage();
		homePage = new HomePage();
	}	
	
	@Test(priority =1)
	public void loginTest() throws InterruptedException{
		getTestDataFromExcel();
		loginpage.login(userName, password);
	}
	
	@Test(priority =2)
	public void searchForProductTest() throws InterruptedException{
		getTestDataFromExcel();
		searchPage.searchForProduct();
		searchPage.clickOnRandomProduct();
	}
	
	@Test(priority =3)
	public void addToCartTest() throws InterruptedException{
		addToCartPage.clickOnAddToCartButton();
		addToCartPage.verifyDetails(productNameInSearchPage,productCostInSearchPage);
		addToCartPage.clickOnplaceorderButton();
		addToCartPage.clickonDeliverHereButton();
		addToCartPage.clickoncontinueButton();
		addToCartPage.clickonFlipkartLogo();
	}
	
	@Test(priority =4)
	public void logOutTest() throws InterruptedException{
		homePage.clickOnLogOut();
	}
	
	
	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
	 

}
