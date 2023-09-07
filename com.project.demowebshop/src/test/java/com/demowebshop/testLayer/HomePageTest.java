package com.demowebshop.testLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demowebshop.pageLayer.HomePage;
import com.demowebshop.testBase.TestBase;
import com.demowebshop.utility.MyListener;

@Listeners(value=MyListener.class)
public class HomePageTest extends TestBase {
	
	HomePage homepage;
	
	
	public HomePageTest() throws IOException {
		super();
		
	}

	@BeforeTest
	public void setUp() throws IOException {
		
		initialization();
		homepage = new HomePage();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyTitle() {
		
		String expectedTitle = "Demo Web Shop";		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	
	
	@Test(priority=2)
	public void verifyLoginText() {
		
		
		String expectedText = "Welcome, Please Sign In!";
		String actualText = homepage.loginClick();		
		Assert.assertEquals(expectedText, actualText);
		
	}
	
	
	
	@Test(priority=3)
	public void verifyRegisterLink() {
		
		Boolean expected = homepage.registerLink();
		
		Boolean actual = driver.findElement(By.linkText("Register")).isDisplayed();
		
		Assert.assertEquals(expected,actual);	
		
	}
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	

}
