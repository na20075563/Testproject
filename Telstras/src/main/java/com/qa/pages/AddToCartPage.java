package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.CommonFunctions;

public class AddToCartPage extends CommonFunctions{
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "(//a[@class='_325-ji _3ROAwx'])[1]")
	WebElement productNameInCheckOutPage;
	
	@FindBy(xpath = "(//span[@class='pMSy0p XU9vZa'])[1]")
	WebElement productCostInCheckOutPage;
	
	@FindBy(xpath = "(//div[text()='Remove'])[1]")
	WebElement removeButton;
	
	@FindBy(xpath = "//span[text()='Place Order']")
	WebElement placeorderButton;
	
	@FindBy(xpath = "//button[text()='Deliver Here']")
	WebElement DeliverHereButton;
	
	@FindBy(xpath = "//button[text()='CONTINUE']")
	WebElement continueButton;
	
	@FindBy(xpath = "//img[@title='Flipkart']/..")
	WebElement flipkartlogo;
	
	@FindBy(xpath = "//div[text()='Satish']/../../..")
	WebElement username;
	
	@FindBy(xpath = "//div[text()='Logout']")
	WebElement logOut;
	
	
	String product_NameInCheckOutPage,product_CostInCheckOutPage;
	public AddToCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButton() throws InterruptedException{
		safeClick(addToCartButton);
		waitForPageLoaded();
		Thread.sleep(10000);
		waitForElement(productNameInCheckOutPage);
		product_NameInCheckOutPage = productNameInCheckOutPage.getText();
		product_CostInCheckOutPage = productCostInCheckOutPage.getText();	
	}
	
	public void clickOnplaceorderButton() throws InterruptedException{
		safeClick(placeorderButton);
		waitForPageLoaded();
		Thread.sleep(10000);
	}
	
	public void clickonDeliverHereButton() throws InterruptedException{
		safeClick(DeliverHereButton);
		waitForPageLoaded();
		Thread.sleep(5000);
	}
	
	public void clickoncontinueButton() throws InterruptedException{
		safeClick(continueButton);
		waitForPageLoaded();
		Thread.sleep(5000);
	}
	
	public void clickonFlipkartLogo() throws InterruptedException{
		safeClick(flipkartlogo);
		waitForPageLoaded();
		Thread.sleep(8000);
	}
	
	public void verifyDetails(String expProduct, String expCost){
		Assert.assertEquals(expProduct, product_NameInCheckOutPage,"Product names are not equal");
		Assert.assertEquals(expCost, product_CostInCheckOutPage,"Product costs are not equal");
	}
	
}
