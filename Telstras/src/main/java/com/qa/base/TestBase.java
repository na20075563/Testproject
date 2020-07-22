package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.TestUtil;

public class TestBase {
public	static WebDriver driver;
public	static Properties prop;
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/SELENIUM_AUTOMATION/Telstras/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
public static void initilization(){
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
		else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
	}
		else if(browsername.equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
		    driver=new InternetExplorerDriver(); 
		}
	driver.manage().window().maximize();
	//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
	
}
