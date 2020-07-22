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
	
	@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[5]")
	WebElement product;
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[5]//div[@class='_3wU53n']")
	WebElement productName;
	
	@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[5]//div[@class='_1vC4OE _2rQ-NK']")
	WebElement productCost;
	
	//@FindBy(xpath = "(//div[@class='bhgxx2 col-12-12']//div[@class='_1UoZlX']/a)[7]//div[@class='_1vC4OE _2rQ-NK']")
	//WebElement productDescription;
	
	@FindBy(xpath = "(//a[@class='_325-ji _3ROAwx'])[1]")
	WebElement productNameInCheckOutPage;
	
	@FindBy(xpath = "(//span[@class='pMSy0p XU9vZa'])[1]")
	WebElement productCostInCheckOutPage;
	
	//@FindBy(xpath = "(//span[@class='pMSy0p XU9vZa'])[1]")
	//WebElement productDescriptionInCheckOutPage;
	
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
	
	
	String productNameInSearchPage, productCostInSearchPage,product_NameInCheckOutPage,product_CostInCheckOutPage;
	//String productNameInSearchPage, productCostInSearchPage, productDescriptionInSearchPage,product_NameInCheckOutPage,product_CostInCheckOutPage,product_DescriptionInSearchPage;
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
	
	public void clickOnAddToCartButton() throws InterruptedException{
		safeClick(addToCartButton);
		waitForPageLoaded();
		Thread.sleep(10000);
		waitForElement(productNameInCheckOutPage);
		product_NameInCheckOutPage = productNameInCheckOutPage.getText();
		product_CostInCheckOutPage = productCostInCheckOutPage.getText();	
		//product_DescriptionInSearchPage = productDescriptionInCheckOutPage.getText();
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
		Thread.sleep(5000);
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
	
	public void verifyDetails(){
		Assert.assertEquals(productNameInSearchPage, product_NameInCheckOutPage,"Product names are not equal");
		Assert.assertEquals(productCostInSearchPage, product_CostInCheckOutPage,"Product costs are not equal");
		//Assert.assertEquals(productDescriptionInSearchPage, product_DescriptionInSearchPage,"Product Descriptions are not equal");
	}
	
	public void removeItemFromCart() throws InterruptedException{
		removeButton.click();
		//Thread.sleep(3000);
		//switchToNewWindow();
		//removeButton.click();
	}
}
