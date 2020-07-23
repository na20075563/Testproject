package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.base.TestBase;

public class CommonFunctions extends TestBase{
	
    protected static String userName;
	protected static String password;
	protected static String productNameInSearchPage;
	protected static String productCostInSearchPage;
	String currentDir;
	
	//To switch to a new window of a web page
	public void switchToNewWindow(){
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();	
		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle .equals(winHandleBefore)){
		    driver.switchTo().window(winHandle);
			}
		}
	}
	
	//To wait for element visibility on a web page
	public void waitForElement(WebElement element){
		 WebDriverWait wait = new WebDriverWait(driver,150);
         wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//TO wait until page gets loaded
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(pageLoadCondition);
    }
	
	
	//To hover on a web element
	public void hoverOnElement(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	//To highlight a web element
	public void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		try{
		Thread.sleep(1000);
		}catch(Exception e){}
		js.executeScript("arguments[0].style.border='0px'", element);
 
	}
	
	//To scroll web page to a particular web element
	public void scrollToElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	//To click on a web element
	public void safeClick(WebElement element){
		waitForElement(element);
		highlightElement(element);
		try{
			if(element.isDisplayed()){
				element.click();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//To type a particulat text in the textbox
	public void safeSendKeys(WebElement element, String value){
		waitForElement(element);
		highlightElement(element);
		try{
			if(element.isDisplayed()){
				element.sendKeys(value);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//To get username and password from the excel sheet
	public void getTestDataFromExcel(){
		try
        {
            File file = new File(System.getProperty("user.dir")+"/resources/data/TestData.xlsx");
            FileInputStream iFile = new FileInputStream(file);

            XSSFWorkbook wb = new XSSFWorkbook(iFile);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum();
            System.out.println("the no of rows are : " + rowCount);
            for (int row=1; row<=rowCount; row++)
            {
            	userName = sheet.getRow(row).getCell(0).getStringCellValue();
                password = sheet.getRow(row).getCell(1).getStringCellValue();
                System.out.println(userName + " , " + password);

            }

            iFile.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}

}
