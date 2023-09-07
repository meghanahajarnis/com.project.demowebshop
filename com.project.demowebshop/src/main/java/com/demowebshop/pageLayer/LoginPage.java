package com.demowebshop.pageLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.testBase.TestBase;

public class LoginPage extends TestBase {
		
	
	@FindBy(xpath="//input[@id='Email']")
	static WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	static WebElement password;
	
	@FindBy(xpath="//input[@value='Log in']")
	static WebElement login_button;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	static WebElement logout_link;
	
	@FindBy(xpath="//a[@class='account']")
	static WebElement login_user;
	
	@FindBy(xpath="//a[@class='ico-login']")
	static WebElement login_link;
	
	@FindBy(xpath="//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")
	public static WebElement login_error;
	

	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, HomePage.class);
		
	}
	
	
	public void enterLoginDetails(String uname, String pwd) {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
		
		
	}
	
	public void clearTextBox() {
		
		username.clear();
		password.clear();
		
		
	}

	
	public void logoutLink() {
		
		logout_link.click();
				
	}
	

	public void loginButton() {		
		
		login_button.click();		
		
		

	}
	
	
	public void loginLink() {
		
		login_link.click();
		
		
	}
	
	
	
}
