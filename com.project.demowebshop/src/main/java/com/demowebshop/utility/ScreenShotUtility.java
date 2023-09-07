package com.demowebshop.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demowebshop.testBase.TestBase;

public class ScreenShotUtility extends TestBase {
	
	public String takeScreenShot() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String path = ".\\test-output\\Screenshots\\MyScreenshots_"+System.currentTimeMillis()+".png";
		
		File target = new File(path);
		FileUtils.copyFile(source, target);
		
		String targetPath = target.getAbsolutePath();
		
		return targetPath;
		
		
	}
	

	public ScreenShotUtility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

}
