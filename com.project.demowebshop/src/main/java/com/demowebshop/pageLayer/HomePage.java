package com.demowebshop.pageLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demowebshop.testBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[@class='ico-login']")
	static WebElement login_link;
	
	@FindBy(xpath="//h1[normalize-space()='Welcome, Please Sign In!']")
	static WebElement signIn_Text;	
	
	@FindBy(xpath="//a[@class='ico-register']")
	static WebElement register_link;	
	
	
	
	
	

	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public Boolean registerLink() {
		
		return (register_link.isDisplayed());		
		
	}

	
	public String loginClick() {
		
		
		login_link.click();
		
		String actualText = signIn_Text.getText();
		
		return actualText;
		
	}

	

}
