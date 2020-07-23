package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.CommonFunctions;

public class SearchPage extends CommonFunctions{
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[7]")
	WebElement product;
	
	@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[7]//div[@class='_3wU53n']")
	WebElement productName;
	
	@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[7]//div[@class='_1vC4OE _2rQ-NK']")
	WebElement productCost;
	
	public SearchPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void searchForProduct() throws InterruptedException{
		waitForPageLoaded();
		safeClick(searchTextBox);
		safeSendKeys(searchTextBox, "Camera");
		safeClick(searchButton);
		waitForPageLoaded();
	}
	
	public void clickOnRandomProduct(){
		waitForElement(product);
		productNameInSearchPage = productName .getText();
		productCostInSearchPage = productCost.getText();
		scrollToElement(product);
		safeClick(product);
		switchToNewWindow();
	}
	
}
