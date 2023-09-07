package com.demowebshop.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.demowebshop.utility.MyEventHandler;
import com.demowebshop.utility.Utility;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream file = new FileInputStream(".\\src\\main\\java\\com\\demowebshop\\config\\config.properties");
		prop.load(file);
		
		
	}
	
	
	
	public static void initialization() throws IOException {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			
			//To convert driver into event firing webdriver
			EventFiringWebDriver efdriver = new EventFiringWebDriver(driver);
			MyEventHandler brevent = new MyEventHandler();
			efdriver.register(brevent);			
			driver = efdriver;
			//To convert driver into event firing webdriver
			
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
