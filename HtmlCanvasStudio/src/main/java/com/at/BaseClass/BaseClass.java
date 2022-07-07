package com.at.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
	
	public static WebDriver driver;
	Properties prop;
	
	public BaseClass() {
		PageFactory.initElements(driver, this);
	}
	
	public void setBrowser() throws IOException {
		FileInputStream file = new FileInputStream("config.properties");
		prop = new Properties();  
		prop.load(file);
		
		String browser = prop.getProperty("Browser");
		String driverLocation = prop.getProperty("DriverLocation");
		
		if (browser.equalsIgnoreCase("chrome")) {                                 
			System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver();                                          
			}
		
		else if (browser.equalsIgnoreCase("firefox")) {                           
			System.setProperty("webdriver.gecko.driver", driverLocation);         
			driver = new FirefoxDriver();                                         
			}
	}
		
		public void launchUrl() throws InterruptedException {
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			
		}
		
	
	     
	
}
