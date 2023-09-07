package com.demowebshop.testLayer;


import java.io.IOException;

import org.testng.annotations.*;
import com.demowebshop.pageLayer.HomePage;
import com.demowebshop.pageLayer.LoginPage;
import com.demowebshop.testBase.TestBase;
import com.demowebshop.utility.MyListener;
import com.demowebshop.utility.ReadExcel;
import com.demowebshop.utility.WriteExcel;

//@Listeners(value=MyListener.class)
public class LoginPageTest extends TestBase {
	
	//HomePage homepage;
	LoginPage loginpage;
	ReadExcel readexcel;
	//WriteExcel	writeexcel;



	public LoginPageTest() throws IOException {
		super();
		
	}
	
	
	@DataProvider
	public Object[][] loginData() throws IOException{
		
			
		int lastRowNo = readexcel.getLastRow(".\\src\\main\\resources\\TestData.xls", "login_credentials");
		
		Object[][] mydata = new Object [lastRowNo+1][2];
	
				
		for(int i=1; i<=lastRowNo; i++) {
			
				
			mydata[i][0] = readexcel.ExcelReader(".\\src\\main\\resources\\TestData.xls", "login_credentials", i, 0);
			mydata[i][1] = readexcel.ExcelReader(".\\src\\main\\resources\\TestData.xls", "login_credentials", i, 1);
			System.out.println(mydata[i][1]);
		
		}
		
		return mydata;
		
	}
		

	
	
	@BeforeTest
	public void setUp() throws IOException {
		
		initialization();
		//homepage = new HomePage();
		loginpage = new LoginPage();
		readexcel = new ReadExcel();
		//writeexcel = new WriteExcel();

		
	}
	

	@Test(dataProvider="loginData")
	public void verifyLogin(String uname, String pwd) throws InterruptedException {
				
		
		loginpage.loginLink();		
		loginpage.enterLoginDetails(uname, pwd);		
		loginpage.loginButton();	
		Thread.sleep(3000);
		
			try {
				
				System.out.println("Pass");
			}catch(java.lang.IllegalArgumentException e) {
				System.out.println("Fail");
			
			}catch(org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Fail");
				
			}			
				
		
		
		loginpage.logoutLink();
		loginpage.loginLink();			
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
		
		
}
	
	



